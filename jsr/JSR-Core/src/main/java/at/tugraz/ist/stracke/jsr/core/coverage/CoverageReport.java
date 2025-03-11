package at.tugraz.ist.stracke.jsr.core.coverage;

import at.tugraz.ist.stracke.jsr.core.shared.TestCase;
import at.tugraz.ist.stracke.jsr.core.tsr.TSRTestCase;
import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.nullness.qual.NonNull;
import java.lang.Math;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class CoverageReport implements Serializable {

  private final Logger logger = LogManager.getLogger(CoverageReport.class);

  public final String coverageType;
  public final Date createdAt;

  public final Set<Unit> allUnits;
  public final Set<Unit> coveredUnits;
  public final Map<TestCase, Set<Unit>> testCaseCoverageData;

  private List<TSRTestCase> sortedTestCases;

  private final Map<Unit, Integer> efMap;
  private final Map<Unit, Integer> nfMap;
  private final Map<Unit, Integer> epMap;
  private final Map<Unit, Integer> npMap;
  private final Map<Unit, Double> coOchiaiMap;
  private final Map<Unit, Integer> rankOchiaiMap;
  private final Map<Unit, Double> coTarantulaMap;
  private final Map<Unit, Integer> rankTarantulaMap;
  private final Map<Unit, Double> coNewFormulaMap;
  private final Map<Unit, Integer> rankNewFormulaMap;

  public CoverageReport(String coverageType,
                        Set<Unit> allUnits,
                        Set<Unit> coveredUnits,
                        Map<TestCase, Set<Unit>> testCaseCoverageData) {
    this.coverageType = coverageType;
    this.allUnits = allUnits;
    this.coveredUnits = coveredUnits;
    this.testCaseCoverageData = testCaseCoverageData;
    this.createdAt = new Date();

    this.efMap = new HashMap<>();
    this.nfMap = new HashMap<>();
    this.epMap = new HashMap<>();
    this.npMap = new HashMap<>();
    this.coOchiaiMap = new HashMap<>();
    this.rankOchiaiMap = new HashMap<>();
    this.coTarantulaMap = new HashMap<>();
    this.rankTarantulaMap = new HashMap<>();
    this.coNewFormulaMap = new HashMap<>();
    this.rankNewFormulaMap = new HashMap<>();

    calculateSFLMetrics();
  }

  private void calculateSFLMetrics() {
    ArrayList<Double> suspicous_valuesOchiai = new ArrayList<Double>();
    ArrayList<Double> suspicous_valuesTarantula = new ArrayList<Double>();
    ArrayList<Double> suspicous_valuesNewFormula = new ArrayList<Double>();

    for (Unit unit : allUnits) {
      int ef = 0;
      int nf = 0;
      int ep = 0;
      int np = 0;
      String name = unit.toString().split(":")[0];
      for (Map.Entry<TestCase, Set<Unit>> entry : testCaseCoverageData.entrySet()){
        TestCase testCase = entry.getKey();
        boolean coversUnit = entry.getValue().contains(unit);
        boolean similar = false;
        if(testCase.getClassName().length() > 4) {
          similar = name.equals(testCase.getClassName().substring(0, testCase.getClassName().length() - 4));
        }
        if(testCase.getClassName().length() > 5) {
          similar = similar || name.equals(testCase.getClassName().substring(0, testCase.getClassName().length() - 5));
        }
        if((testCase.isPassed()) && (similar))
        {
          if(coversUnit) {
            ep++;
          } else {
            np++;
          }
        }else if((!testCase.isPassed()) && (similar)){
          if(coversUnit) {
            ef++;
          } else {
            nf++;
          }
        }
      }
      efMap.put(unit, ef);
      nfMap.put(unit, nf);
      epMap.put(unit, ep);
      npMap.put(unit, np);
      Double svOchiai = 0.0;
      Double svTarantula = 0.0;
      Double svNewFormula = 0.0;
      if (ef!=0){
        svOchiai = ef/(Math.sqrt((ef+nf)*(ef+ep)));
        svTarantula = ((((double)ef)/(ef + nf))/((((double)ep)/(ep+np))+(((double)ef)/(ef+nf))));
        svNewFormula = ef + (((double)(ef-nf)/(ef+nf+ep)));
      }
      if (Double.isNaN(svTarantula)) {
        svTarantula = 0.0;
      }
      coOchiaiMap.put(unit, svOchiai);
      suspicous_valuesOchiai.add(svOchiai);
      coTarantulaMap.put(unit, svTarantula);
      suspicous_valuesTarantula.add(svTarantula);
      coNewFormulaMap.put(unit, svNewFormula);
      suspicous_valuesNewFormula.add(svNewFormula);
      //logger.info(unit + "ef:" + ef + "nf:" + nf + "ep:" + ep + "np:" + np);
    }
    List<Double> Unique_suspicous_valuesOchiai = suspicous_valuesOchiai.stream().distinct().collect(Collectors.toList());
    Collections.sort(Unique_suspicous_valuesOchiai, Collections.reverseOrder());

    List<Double> Unique_suspicous_valuesTarantula = suspicous_valuesTarantula.stream().distinct().collect(Collectors.toList());
    Collections.sort(Unique_suspicous_valuesTarantula, Collections.reverseOrder());

    List<Double> Unique_suspicous_valuesNewFormula = suspicous_valuesNewFormula.stream().distinct().collect(Collectors.toList());
    Collections.sort(Unique_suspicous_valuesNewFormula, Collections.reverseOrder());

    Map<String, List<Unit>> unitsByClass = allUnits.stream().collect(Collectors.groupingBy(unit -> getClassName(unit)));
    for (Map.Entry<String, List<Unit>> entry : unitsByClass.entrySet()) {
      String className = entry.getKey();
      List<Unit> classUnits = entry.getValue();

      List<Double> classSuspValuesOchiai = classUnits.stream()
                                                     .map(u -> coOchiaiMap.get(u))
                                                     .distinct()
                                                     .sorted(Comparator.reverseOrder())
                                                     .collect(Collectors.toList());

      int classCounter = 1;
      for (Double svOchiai : classSuspValuesOchiai) {
        for (Unit unit : classUnits) {
          if (Math.abs(coOchiaiMap.get(unit) - svOchiai) < 1e-15) {
            if (Math.abs(svOchiai) < 1e-15) {
              rankOchiaiMap.put(unit, classSuspValuesOchiai.size());
            } else {
              rankOchiaiMap.put(unit, classCounter);
            }
          }
        }
        classCounter++;
      }
    }



    for (Map.Entry<String, List<Unit>> entry : unitsByClass.entrySet()) {
      String className = entry.getKey();
      List<Unit> classUnits = entry.getValue();

      List<Double> classSuspValuesTarantula = classUnits.stream()
                                                     .map(u -> coTarantulaMap.get(u))
                                                     .distinct()
                                                     .sorted(Comparator.reverseOrder())
                                                     .collect(Collectors.toList());

      int classCounter = 1;
      for (Double svTarantula : classSuspValuesTarantula) {
        for (Unit unit : classUnits) {
          if (Math.abs(coTarantulaMap.get(unit) - svTarantula) < 1e-15) {
            if (Math.abs(svTarantula) < 1e-15) {
              rankTarantulaMap.put(unit, classSuspValuesTarantula.size());
            } else {
              rankTarantulaMap.put(unit, classCounter);
            }
          }
        }
        classCounter++;
      }
    }


    for (Map.Entry<String, List<Unit>> entry : unitsByClass.entrySet()) {
      String className = entry.getKey();
      List<Unit> classUnits = entry.getValue();

      List<Double> classSuspValuesNew = classUnits.stream()
                                                     .map(u -> coNewFormulaMap.get(u))
                                                     .distinct()
                                                     .sorted(Comparator.reverseOrder())
                                                     .collect(Collectors.toList());

      int classCounter = 1;
      for (Double svNew : classSuspValuesNew) {
        for (Unit unit : classUnits) {
          if (Math.abs(coNewFormulaMap.get(unit) - svNew) < 1e-15) {
            if (Math.abs(svNew) < 1e-15) {
              rankNewFormulaMap.put(unit, classSuspValuesNew.size());
            } else {
              rankNewFormulaMap.put(unit, classCounter);
            }
          }
        }
        classCounter++;
      }
    }

    //logger.info("Computed SFL metrics");
  }

  public int getEf(Unit unit) {
    return efMap.getOrDefault(unit, 0);
  }

  public int getNf(Unit unit) {
    return nfMap.getOrDefault(unit, 0);
  }

  public int getEp(Unit unit) {
    return epMap.getOrDefault(unit, 0);
  }

  public int getNp(Unit unit) {
    return npMap.getOrDefault(unit, 0);
  }

  public double getcoOchiai(Unit unit) {
    return coOchiaiMap.getOrDefault(unit, 0.0);
  }

  public int getrankOchiai(Unit unit) {
    return rankOchiaiMap.getOrDefault(unit, 0);
  }

  public double getcoTarantula(Unit unit) {
    return coTarantulaMap.getOrDefault(unit, 0.0);
  }

  public int getrankTarantula(Unit unit) {
    return rankTarantulaMap.getOrDefault(unit, 0);
  }

  public double getcoNewFormula(Unit unit) {
    return coNewFormulaMap.getOrDefault(unit, 0.0);
  }

  public int getrankNewFormula(Unit unit) {
    return rankNewFormulaMap.getOrDefault(unit, 0);
  }

  public Set<Unit> getAllUnits(){return allUnits;}

  public String getClassName(Unit unit) {return unit.toString().split(":")[0];}

  public double getCoverageScore() {
    return this.allUnits.size() != 0 ?
           this.coveredUnits.size() / (double) this.allUnits.size() : 0;
  }

  public List<TSRTestCase> getSortedTestCases() {
    if (this.sortedTestCases == null) {
      this.sortedTestCases = testCaseCoverageData.keySet()
                                                 .stream()
                                                 .sorted(Comparator.comparing(TestCase::getFullName))
                                                 .map(TSRTestCase::new)
                                                 .collect(Collectors.toList());
    }
    return this.sortedTestCases;
  }

  public Table<TSRTestCase, Unit, Boolean> toTable(boolean includeUncoveredUnits) {
    List<TSRTestCase> rows = this.getSortedTestCases();
    Set<Unit> columnUnits = includeUncoveredUnits ? this.allUnits : this.coveredUnits;

    List<CoverageReport.Unit> columns = columnUnits.stream()
                                                   .sorted(Comparator.comparing(CoverageReport.Unit::toString))
                                                   .collect(Collectors.toList());

    Table<TSRTestCase, Unit, Boolean> table;

    try {
      table = ArrayTable.create(rows, columns);
    } catch (IllegalArgumentException ex) {
      logger.error("Could not create ArrayTable because the arguments are illegal. " +
                   "Most likely, there was a coverage report problem.");
      logger.error("Got {} rows and {} columns. They must not be 0", rows.size(), columns.size());
      return null;
    }

    testCaseCoverageData.forEach((tc, units) -> units.forEach(u -> table.put(new TSRTestCase(tc), u, true)));

    return table;
  }

  public static class Unit implements Serializable{
    final public String name;
    final public int positionStart;
    final public int positionEnd;

    public Unit(@NonNull String name,
                int positionStart,
                int positionEnd) {
      this.name = name;
      this.positionStart = positionStart;
      this.positionEnd = positionEnd;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.name, this.positionStart/*, this.positionEnd*/);
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof Unit)) {
        return false;
      }
      Unit u = (Unit) obj;
      return this.name.equals(u.name) &&
             this.positionStart == u.positionStart;
      // Note: relaxing the equality criterion here, as sliced statements do not have the end line information
      /*&& this.positionEnd == u.positionEnd;*/
    }

    @Override
    public String toString() {
      return name;
    }
  }
}
