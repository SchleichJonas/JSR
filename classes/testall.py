import jpype
import jpype.imports
import os

jpype.startJVM(classpath=['.'])


dir_content = os.listdir('.')

dir_content = [row for row in dir_content if row.endswith(".class") and "Altered" not in row]
dir_content.sort()

for row in dir_content:
    print(row[:-6])
    Current_class = jpype.JClass(row[:-6])
    Current_class_altered = jpype.JClass(row[:-6] + "Altered")
    
    returns_something = True
    
    try:
        current_class = Current_class()
        current_class_altered = Current_class_altered()
    except:
        current_class = Current_class
        current_class_altered = Current_class_altered
        returns_something = False
    
    passing = 0
    failing = 0
    with open(row[:-6] + ".txt", "r") as f:
        counter = 1
        for line in f:
            line = line.strip()
            if line:
                try:
                    result = eval(f"current_class.{line}")
                    resultAltered = eval(f"current_class_altered.{line}")
                    if(isinstance(result, jpype.JClass("java.math.BigInteger"))):
                        result = int(str(result))
                        resultAltered = int(str(resultAltered))
                    if(result != None and row[:-6] != "Tcas" and row[:-6] != "Tcas2" and row[:-6] != "Tcas3"):
                        if(result == resultAltered):
                            passing += 1
                        else:
                            failing += 1
                        print(f"& {line} & {result} & {resultAltered}\\\\")

                        counter += 1
                    else:
                        with open(row[:-6] + ".variables", "r") as f:
                            for variable in f:
                                variable = variable.strip()
                                if variable:
                                    result = eval(f"Current_class.{variable}")
                                    resultAltered = eval(f"Current_class_altered.{variable}")
                                    if(result == resultAltered):
                                        passing += 1
                                    else:
                                        failing += 1
                                    print(f"& {line} & {variable}={result} & {variable}={resultAltered}\\\\")
                                    counter += 1
                except Exception as e:
                    print(f"Error executing {line}: {e}")
                    failing += 1
                    counter += 1
        print("\\hline")
    
    print("Passing Testcases: " + str(passing))
    print("Failing Testcases: " + str(failing))
    print()
    



jpype.shutdownJVM()
