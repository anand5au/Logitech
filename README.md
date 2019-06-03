# Logitech

Question 1:
The folder "robbing" contains classes
1. RobbingPlanner - Class that defines the method to determine maximum amount that can be robbed in a night.
2. RobbingPlannerTest - Unit tests for RobbingPlanner.
3. RobbingPlannerTest_Log - Output log of test run.

Compilation steps:
1. navigate to the folder "robbing".
2. javac -cp \* *.java
3. java -cp .:junit-4.12.jar:lombok.jar:hamcrest-core-1.3.jar:guava.jar org.junit.runner.JUnitCore RobbingPlannerTest

Question 2:
The folder "employee" contains classes
1. EmployeeDataStore - Data structure to store Employee objects.
2. Employee - Class to represnt an employee.
3. DuplicateEntryException - User defined exception for duplicate employees uses case.
4. EmployeeDataStoreTest - Unit tests for EmployeeDataStore.
5. EmployeeDataStoreTest_Log - Output log of test run.

Compilation steps:
1. navigate to the folder "employee".
2. javac -cp \* *.java
3. java -cp .:junit-4.12.jar:lombok.jar:hamcrest-core-1.3.jar:guava.jar org.junit.runner.JUnitCore EmployeeDataStoreTest
