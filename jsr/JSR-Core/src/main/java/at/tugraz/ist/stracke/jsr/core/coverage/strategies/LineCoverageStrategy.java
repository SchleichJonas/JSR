package at.tugraz.ist.stracke.jsr.core.coverage.strategies;

import at.tugraz.ist.stracke.jsr.core.coverage.CoverageReport;
import at.tugraz.ist.stracke.jsr.core.shared.TestCase;
import org.apache.logging.log4j.LogManager;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import at.tugraz.ist.stracke.jsr.core.sfl.exporter.SFLMatrixCsvExporter;
import at.tugraz.ist.stracke.jsr.core.sfl.exporter.SFLMatrixExporter;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LineCoverageStrategy extends JaCoCoCoverageStrategy {

  public LineCoverageStrategy(Path pathToJar,
                              Path pathToClasses,
                              Path pathToSources,
                              Path pathToSlicer,
                              Path pathToOutDir,
                              String basePackage) {
    super(pathToJar,
          pathToClasses,
          pathToSources,
          pathToSlicer,
          pathToOutDir,
          basePackage,
          LogManager.getLogger(LineCoverageStrategy.class));
  }

  @Override
  boolean processTestCaseCoverageReportData(TestCase tc) {
    final Set<CoverageReport.Unit> tmpCoveredUnits = new HashSet<>();
    String tcId = String.format("%s#%s", tc.getClassName(), tc.getName());

    Document document = parseXmlReport(tcId);

    NodeList classes = document.getElementsByTagName("class");
    for (int i = 0; i < classes.getLength(); i++) {
      Node clazz = classes.item(i);
      collectClassData(document, tmpCoveredUnits, clazz);
    }

    this.coveredUnits.addAll(tmpCoveredUnits);
    this.coverageData.put(tc, tmpCoveredUnits);

    firstIteration = false;
    return true;
  }

  private void collectClassData(Document document, Set<CoverageReport.Unit> tmpCoveredUnits, Node clazz) {
    String className = clazz.getAttributes().getNamedItem("name").getTextContent().replace("/", ".").split("\\$")[0];
    String sourceFileName = clazz.getAttributes().getNamedItem("sourcefilename").getTextContent();
    Node sourceFile = this.getSourceFileByName(sourceFileName, document);

    assert sourceFile != null;
    NodeList lineNodes = sourceFile.getChildNodes();

    for (int j = 0; j < lineNodes.getLength(); j++) {
      Node line = lineNodes.item(j);
      if (!line.getNodeName().equals("line")) {
        continue;
      }
      int lineNr = Integer.parseInt(line.getAttributes().getNamedItem("nr").getTextContent());
      int coveredInstructions = Integer.parseInt(line.getAttributes().getNamedItem("ci").getTextContent());

      final CoverageReport.Unit lineUnit = new CoverageReport.Unit(String.format("%s:%s", className, lineNr),
                                                                   lineNr,
                                                                   lineNr);
      if (firstIteration) {
        this.allUnits.add(lineUnit);
      }
      if (coveredInstructions > 0) {
        tmpCoveredUnits.add(lineUnit);
      }
    }
  }

  private Node getSourceFileByName(String sourceFileName, Document document) {
    NodeList sourceFiles = document.getElementsByTagName("sourcefile");
    for (int i = 0; i < sourceFiles.getLength(); i++) {
      Node sf = sourceFiles.item(i);
      String n = sf.getAttributes().getNamedItem("name").getTextContent();
      if (sourceFileName.equals(n)) {
        return sf;
      }
    }
    return null;
  }

  @Override
  CoverageReport assembleReport() {
    final CoverageReport report = new CoverageReport("Line",
                                                     this.allUnits,
                                                     this.coveredUnits,
                                                     this.coverageData);

    SFLMatrixExporter exporter = new SFLMatrixCsvExporter(report, Path.of("JSR-CLI/build/jsr/cliTest01/coverageMatrix_line_coverage"));
    exporter.exportSFLMatrices();

    logger.info("Successfully created coverage report: {} of {} lines covered. Coverage score: {}",
                report.coveredUnits.size(),
                report.allUnits.size(),
                report.getCoverageScore());

    return report;
  }
}
