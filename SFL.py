import csv
import re
from collections import defaultdict
import os
import numpy

def read_csv_group_headers(file_path):
    with open(file_path, newline='', encoding='utf-8') as csvfile:
        reader = csv.reader(csvfile)
        headers = next(reader)  # Read the first row as headers
        
        grouped_data = defaultdict(list)
        
        for row in reader:
            for header, value in zip(headers, row):
                grouped_data[header].append(value)
        
    return grouped_data


def get_entries_by_base(grouped_data, base_name):
    """Retrieve all entries that match the base name (ignoring the number)."""
    pattern = re.compile(rf"^{re.escape(base_name)}:\d+$")  # Match "base_name:NUMBER"
    matching_entries = {key: values for key, values in grouped_data.items() if pattern.match(key)}
    return matching_entries


def get_SFL_metrics(class_name, error):
    try:
        Rank_Ochiai = int(class_name[error][len(class_name[error])-5])
        Rank_Tarantula = int(class_name[error][len(class_name[error])-3])
        Rank_New = int(class_name[error][len(class_name[error])-1])
    except:
        Rank_Ochiai = -1
        Rank_Tarantula = -1
        Rank_New = -1
        for key, values in class_name.items():
            if(int(values[len(class_name[key])-5]) > Rank_Ochiai):
                Rank_Ochiai = int(values[len(class_name[key])-5])
                
            if(int(values[len(class_name[key])-3]) > Rank_Tarantula):
                Rank_Tarantula = int(values[len(class_name[key])-3])
                
            if(int(values[len(class_name[key])-1]) > Rank_New):
                Rank_New = int(values[len(class_name[key])-1])
        
    
    
    Wasted_Effort_Ochiai = 0
    Wasted_Effort_Tarantula = 0
    Wasted_Effort_New = 0

    
    for key, values in class_name.items():
        #print(key + " Ochiai: " + str(values[len(class_name[error])-5]) + " Tarantula: " + str(values[len(class_name[error])-3]) + " New: " + str(values[len(class_name[error])-1]))
        if(int(values[len(class_name[key])-5]) < Rank_Ochiai):
            Wasted_Effort_Ochiai += 1
        elif(int(values[len(class_name[key])-5]) == Rank_Ochiai):
            Wasted_Effort_Ochiai += 0.5
            
        if(int(values[len(class_name[key])-3]) < Rank_Tarantula):
            Wasted_Effort_Tarantula += 1
        elif(int(values[len(class_name[key])-3]) == Rank_Tarantula):
            Wasted_Effort_Tarantula += 0.5
            
        if(int(values[len(class_name[key])-1]) < Rank_New):
            Wasted_Effort_New += 1
        elif(int(values[len(class_name[key])-1]) == Rank_New):
            Wasted_Effort_New += 0.5
    
    Wasted_Effort_Ochiai -= 0.5
    Wasted_Effort_Tarantula -= 0.5
    Wasted_Effort_New -= 0.5
    
    print("Rank Ochiai: " + str(Rank_Ochiai))
    print("Rank Tarantula: " + str(Rank_Tarantula))
    print("Rank New: " + str(Rank_New))
    print("Wasted Effort Ochiai: " + str(Wasted_Effort_Ochiai))
    print("Wasted Effort Tarantula: " + str(Wasted_Effort_Tarantula))
    print("Wasted Effort New: " + str(Wasted_Effort_New))
    
    return Rank_Ochiai, Rank_Tarantula, Rank_New, Wasted_Effort_Ochiai, Wasted_Effort_Tarantula, Wasted_Effort_New


def get_error_line(class_name):
    class_path = "./jsr/JSR-Core/src/test/resources/smallProject/src/main/java/at/tugraz/ist/stracke/jsr/"
    with open(class_path + class_name + ".java") as fp:
        lines = fp.readlines()


    for i in range(len(lines)):
        if "//Error" in lines[i]:
            return class_name + ":" + str(i+1)
    return -1

def evaluateSFLMetrics(classes, table_name, grouped_headers):
    print("==================================================================================")
    fp = open(table_name + "Detailed.txt", "w")
    fp.write("\\begin{table}[H]\n")
    fp.write("\small\n")
    fp.write("\centering\n")
    fp.write("    \caption{}\n")
    fp.write("    \\begin{tabular}{|c|c|c|c|c|c|c|}\n")
    fp.write("    \hline\n")
    fp.write("        Class & \multicolumn{2}{c|}{Ochiai} & \multicolumn{2}{c|}{Tarantula} & \multicolumn{2}{c|}{Sarhan-Beszédes}\\\\\n")
    fp.write("        \hline\n")
    fp.write("        & Rank & WE & Rank & WE & Rank & WE\\\\\n")
    fp.write("        \hline\n")
    
    outcome_path = "jsr/JSR-CLI/build/jsr/cliTest01/coverageMatrix_checked_coverage/outcomeMatrix.csv"

    outcome = numpy.loadtxt(open(outcome_path, "rb"), delimiter=",", skiprows=1, dtype=str)
    
    HitRatioAt1 = [0.0, 0.0, 0.0]
    HitRatioAt5 = [0.0, 0.0, 0.0]
    OverallWastedEffort = [0.0, 0.0, 0.0]
    
    for i in range(len(classes)):
        print("Class: " + classes[i])
        error = str(get_error_line(classes[i]))
        if(error == "-1"):
            raise Exception("Line with Error was not found! Maybe add //Error to the corresponding line")
        print("Error: " + error)
        passing = 0
        failing = 0
        for line in outcome:
            if(classes[i] + "Test" in line[0]):
                if(line[1] == "1"):
                    passing += 1
                else:
                    failing += 1
        print("Passing Testcases: " + str(passing))
        print("Failing Testcases: " + str(failing))
        class_name = get_entries_by_base(grouped_headers, prefix + classes[i])
        Rank_Ochiai, Rank_Tarantula, Rank_New, Wasted_Effort_Ochiai, Wasted_Effort_Tarantula, Wasted_Effort_New = get_SFL_metrics(class_name, prefix + error)
        fp.write(f"        {classes[i]} & {Rank_Ochiai} & {Wasted_Effort_Ochiai} & {Rank_Tarantula} & {Wasted_Effort_Tarantula} & {Rank_New} & {Wasted_Effort_New}\\\\\n")
        fp.write("        \hline\n")
        OverallWastedEffort[0] += Wasted_Effort_Ochiai
        OverallWastedEffort[1] += Wasted_Effort_Tarantula
        OverallWastedEffort[2] += Wasted_Effort_New
        if(int(Rank_Ochiai) == 1):
            HitRatioAt1[0] += 1
        if(int(Rank_Ochiai) <= 5):
            HitRatioAt5[0] += 1
        
        if(int(Rank_Tarantula) == 1):
            HitRatioAt1[1] += 1
        if(int(Rank_Tarantula) <= 5):
            HitRatioAt5[1] += 1
            
        if(int(Rank_New) == 1):
            HitRatioAt1[2] += 1
        if(int(Rank_New) <= 5):
            HitRatioAt5[2] += 1
        print()
        
    fp.write("    \end{tabular}\n")
    fp.write("\end{table}\n")
    fp.close()
    
    HitRatioAt1[0] = HitRatioAt1[0] / len(classes)
    HitRatioAt1[1] = HitRatioAt1[1] / len(classes)
    HitRatioAt1[2] = HitRatioAt1[2] / len(classes)
    
    HitRatioAt5[0] = HitRatioAt5[0] / len(classes)
    HitRatioAt5[1] = HitRatioAt5[1] / len(classes)
    HitRatioAt5[2] = HitRatioAt5[2] / len(classes)

    print("HitRatio@1 Ochiai: " + str(HitRatioAt1[0]))
    print("HitRatio@1 Tarantula: " + str(HitRatioAt1[1]))
    print("HitRatio@1 New: " + str(HitRatioAt1[2]))
    
    print()
    
    print("HitRatio@5 Ochiai: " + str(HitRatioAt5[0]))
    print("HitRatio@5 Tarantula: " + str(HitRatioAt5[1]))
    print("HitRatio@5 New: " + str(HitRatioAt5[2]))
    
    print()
    
    OverallWastedEffort[0] = OverallWastedEffort[0] / len(classes)
    OverallWastedEffort[1] = OverallWastedEffort[1] / len(classes)
    OverallWastedEffort[2] = OverallWastedEffort[2] / len(classes)
    
    print("OverallWastedEffort Ochiai: " + str(OverallWastedEffort[0]))
    print("OverallWastedEffort Tarantula: " + str(OverallWastedEffort[1]))
    print("OverallWastedEffort New: " + str(OverallWastedEffort[2]))
    
    
    print("==================================================================================")
    return HitRatioAt1, HitRatioAt5, OverallWastedEffort

def createOverallResultsTable(HitRatioAt1, HitRatioAt5, OverallWastedEffort, table_name, HitRatioAt1_not_sliced, HitRatioAt5_not_sliced, OverallWastedEffort_not_sliced):
    fp = open(table_name + ".txt", "w")
    fp.write("\\begin{table}[H]\n")
    fp.write("\small\n")
    fp.write("\centering\n")
    fp.write("    \caption{}\n")
    fp.write("    \\begin{tabular}{|c|c|c|c|c|c|c|c|c|c|}\n")
    fp.write("    \hline\n")
    fp.write("        Class & \multicolumn{3}{c|}{Ochiai} & \multicolumn{3}{c|}{Tarantula} & \multicolumn{3}{c|}{Sarhan-Beszédes}\\\\\n")
    fp.write("        \hline\n")
    fp.write("        & Hit@1 & Hit@5 & WE & Hit@1 & Hit@5 & WE & Hit@1 & Hit@5 & WE\\\\\n")
    fp.write("        \hline\n")
    fp.write(f"        Not Sliced & {round(HitRatioAt1_not_sliced[0], 5)} & {round(HitRatioAt5_not_sliced[0],5)} & {round(OverallWastedEffort_not_sliced[0],5)} & {round(HitRatioAt1_not_sliced[1],5)} & {round(HitRatioAt5_not_sliced[1],5)} & {round(OverallWastedEffort_not_sliced[1],5)} & {round(HitRatioAt1_not_sliced[2],5)} & {round(HitRatioAt5_not_sliced[2],5)} & {round(OverallWastedEffort_not_sliced[2],5)}\\\\\n")
    fp.write("        \hline\n")
    fp.write(f"        Sliced & {round(HitRatioAt1[0], 5)} & {round(HitRatioAt5[0],5)} & {round(OverallWastedEffort[0],5)} & {round(HitRatioAt1[1],5)} & {round(HitRatioAt5[1],5)} & {round(OverallWastedEffort[1],5)} & {round(HitRatioAt1[2],5)} & {round(HitRatioAt5[2],5)} & {round(OverallWastedEffort[2],5)}\\\\\n")
    fp.write("    \hline\n")
    fp.write("    \end{tabular}\n")
    fp.write("\end{table}\n")
    fp.close()

if __name__ == "__main__":
    file_path_sliced = "jsr/JSR-CLI/build/jsr/cliTest01/coverageMatrix_checked_coverage/coverageMatrix.csv"
    grouped_headers_sliced = read_csv_group_headers(file_path_sliced)
    
    file_path_not_sliced = "jsr/JSR-CLI/build/jsr/cliTest01/coverageMatrix_line_coverage/coverageMatrix.csv"
    grouped_headers_not_sliced = read_csv_group_headers(file_path_not_sliced)
    
    prefix = "at.tugraz.ist.stracke.jsr."
    
    classes_just_one_output = ["BMIJustOneOutput", "ExpintJustOneOutput", "FisherJustOneOutput", "GammqJustOneOutput", "LuhnJustOneOutput", "MiddleJustOneOutput", "TcasJustOneOutput", "BMIJustOneOutput2", "ExpintJustOneOutput2", "FisherJustOneOutput2", "GammqJustOneOutput2", "LuhnJustOneOutput2", "MiddleJustOneOutput2", "TcasJustOneOutput2", "BMIJustOneOutput3", "ExpintJustOneOutput3", "FisherJustOneOutput3", "GammqJustOneOutput3"]
    #errors_just_one_output = ["BMIJustOneOutput:17", "ExpintJustOneOutput:43", "FisherJustOneOutput:10", "GammqJustOneOutput:37", "LuhnJustOneOutput:14", "MiddleJustOneOutput:6", "TcasJustOneOutput:54"]
    classes_just_one_output.sort()
    
    classes_division_by_1 = ["BMIJustOneOutput", "ExpintDivisionBy1", "FisherJustOneOutput", "GammqJustOneOutput", "LuhnJustOneOutput", "MiddleJustOneOutput", "TcasDivisionBy1", "BMIJustOneOutput2", "ExpintJustOneOutput2", "FisherJustOneOutput2", "GammqJustOneOutput2", "LuhnJustOneOutput2", "MiddleJustOneOutput2", "TcasJustOneOutput2", "BMIJustOneOutput3", "ExpintJustOneOutput3", "FisherJustOneOutput3", "GammqJustOneOutput3"]
    #classes_division_by_1 = ["BMIJustOneOutput", "ExpintDivisionBy1", "FisherJustOneOutput", "GammqJustOneOutput", "LuhnJustOneOutput", "MiddleJustOneOutput", "TcasDivisionBy1"]
    classes_division_by_1.sort()
    
    classes_multiplication_by_1 = ["BMIJustOneOutput", "ExpintMultiplicationBy1", "FisherJustOneOutput", "GammqJustOneOutput", "LuhnJustOneOutput", "MiddleJustOneOutput", "TcasMultiplicationBy1", "BMIJustOneOutput2", "ExpintJustOneOutput2", "FisherJustOneOutput2", "GammqJustOneOutput2", "LuhnJustOneOutput2", "MiddleJustOneOutput2", "TcasJustOneOutput2", "BMIJustOneOutput3", "ExpintJustOneOutput3", "FisherJustOneOutput3", "GammqJustOneOutput3"]
    #classes_multiplication_by_1 = ["BMIJustOneOutput", "ExpintMultiplicationBy1", "FisherJustOneOutput", "GammqJustOneOutput", "LuhnJustOneOutput", "MiddleJustOneOutput", "TcasMultiplicationBy1"]
    classes_multiplication_by_1.sort()
    
    classes_second_testsuite = ["Armstrong", "BubbleSort", "ChineseRemainder", "Factorial", "GCD", "InverseCounter", "Isprime", "LCM", "LogExp", "Minimax", "ModInverse", "Mult", "RSA", "RussianPeasant", "Sqrt"]
    #errors_second_testsuite = ["Armstrong:34", "BubbleSort:35", "ChineseRemainder:26", "Factorial:7", "GCD:12", "InverseCounter:12", "Isprime:10", "LCM:10", "LogExp:12", "Minimax:48", "ModInverse:30", "Mult:17", "RSA:14", "RussianPeasant:19", "Sqrt:17"]
    classes_second_testsuite.sort()
    
    classes_fixed = ["BMI", "Expint", "Fisher", "Gammq", "Luhn", "Middle", "Tcas", "BMI2", "Expint2", "Fisher2", "Gammq2", "Luhn2", "Middle2", "Tcas2", "BMI3", "Expint3", "Fisher3", "Gammq3"]
    #errors_fixed = ["BMI:20", "Expint:46", "Fisher:15", "Gammq:38", "Luhn:14", "Middle:6", "Tcas:61"]
    classes_fixed.sort()
    
    table_name = "fixedTable"
    print(table_name)
    print("sliced:")
    HitRatioAt1_sliced, HitRatioAt5_sliced, OverallWastedEffort_sliced = evaluateSFLMetrics(classes_fixed, table_name + "_sliced", grouped_headers_sliced)
    print("not sliced:")
    HitRatioAt1_not_sliced, HitRatioAt5_not_sliced, OverallWastedEffort_not_sliced = evaluateSFLMetrics(classes_fixed, table_name + "_not_sliced", grouped_headers_not_sliced)
    createOverallResultsTable(HitRatioAt1_sliced, HitRatioAt5_sliced, OverallWastedEffort_sliced, table_name, HitRatioAt1_not_sliced, HitRatioAt5_not_sliced, OverallWastedEffort_not_sliced)

    table_name = "firstTable"
    print(table_name)
    print("sliced:")
    HitRatioAt1_sliced, HitRatioAt5_sliced, OverallWastedEffort_sliced = evaluateSFLMetrics(classes_just_one_output, table_name + "_sliced", grouped_headers_sliced)
    print("not sliced:")
    HitRatioAt1_not_sliced, HitRatioAt5_not_sliced, OverallWastedEffort_not_sliced = evaluateSFLMetrics(classes_just_one_output, table_name + "_not_sliced", grouped_headers_not_sliced)
    createOverallResultsTable(HitRatioAt1_sliced, HitRatioAt5_sliced, OverallWastedEffort_sliced, table_name, HitRatioAt1_not_sliced, HitRatioAt5_not_sliced, OverallWastedEffort_not_sliced)

    table_name = "first_division_by_1"
    print(table_name)
    print("sliced:")
    HitRatioAt1_sliced, HitRatioAt5_sliced, OverallWastedEffort_sliced = evaluateSFLMetrics(classes_division_by_1, table_name + "_sliced", grouped_headers_sliced)
    print("not sliced:")
    HitRatioAt1_not_sliced, HitRatioAt5_not_sliced, OverallWastedEffort_not_sliced = evaluateSFLMetrics(classes_division_by_1, table_name + "_not_sliced", grouped_headers_not_sliced)
    createOverallResultsTable(HitRatioAt1_sliced, HitRatioAt5_sliced, OverallWastedEffort_sliced, table_name, HitRatioAt1_not_sliced, HitRatioAt5_not_sliced, OverallWastedEffort_not_sliced)

    table_name = "first_multiplication_by_1"
    print(table_name)
    print("sliced:")
    HitRatioAt1_sliced, HitRatioAt5_sliced, OverallWastedEffort_sliced = evaluateSFLMetrics(classes_multiplication_by_1, table_name + "_sliced", grouped_headers_sliced)
    print("not sliced:")
    HitRatioAt1_not_sliced, HitRatioAt5_not_sliced, OverallWastedEffort_not_sliced = evaluateSFLMetrics(classes_multiplication_by_1, table_name + "_not_sliced", grouped_headers_not_sliced)
    createOverallResultsTable(HitRatioAt1_sliced, HitRatioAt5_sliced, OverallWastedEffort_sliced, table_name, HitRatioAt1_not_sliced, HitRatioAt5_not_sliced, OverallWastedEffort_not_sliced)


    table_name = "secondTable"
    print(table_name)
    print("sliced:")
    HitRatioAt1_sliced, HitRatioAt5_sliced, OverallWastedEffort_sliced = evaluateSFLMetrics(classes_second_testsuite, table_name + "_sliced", grouped_headers_sliced)
    print("not sliced:")
    HitRatioAt1_not_sliced, HitRatioAt5_not_sliced, OverallWastedEffort_not_sliced = evaluateSFLMetrics(classes_second_testsuite, table_name + "_not_sliced", grouped_headers_not_sliced)
    createOverallResultsTable(HitRatioAt1_sliced, HitRatioAt5_sliced, OverallWastedEffort_sliced, table_name, HitRatioAt1_not_sliced, HitRatioAt5_not_sliced, OverallWastedEffort_not_sliced)

