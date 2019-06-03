import lombok.SneakyThrows;
import lombok.val;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeDataStoreTest {

    private EmployeeDataStore employeeDataStore;

    @Before
    public void setUp() {
        employeeDataStore = new EmployeeDataStore();
        populateEmployeeDataStore();
        System.out.println("Initial employeeMap:" + employeeDataStore.getEmployeeMap());
        System.out.println("Initial Employees Count: " + employeeDataStore.getEmployeesCount());
    }

    @After
    public void cleanUp() {
        employeeDataStore = null;
    }

    @Test
    @SneakyThrows
    public void testAdd() {
        val employee = Employee.builder()
            .name("Jeremy")
            .department("IT")
            .age(35)
            .build();
        employeeDataStore.addEmployee(employee);
        assertAndPrintTestCase(employee, employeeDataStore.getEmployeesCount(), 4);
    }

    @Test
    @SneakyThrows
    public void testDuplicateNameAdd() {
        val employee = Employee.builder()
            .name("Tyler")
            .department("IT")
            .age(35)
            .build();
        employeeDataStore.addEmployee(employee);
        assertAndPrintTestCase(employee, employeeDataStore.getEmployeesCount(), 4);
    }

    @Test(expected = DuplicateEntryException.class)
    @SneakyThrows
    public void testDuplicateEmployeeAdd() {
        employeeDataStore.addEmployee(Employee.builder()
            .name("Tyler")
            .age(30)
            .department("Engineering")
            .build());

    }

    @Test
    @SneakyThrows
    public void testAddNull() {
        employeeDataStore.addEmployee(null);
        assertAndPrintTestCase(null, employeeDataStore.getEmployeesCount(), 3);
    }

    @Test
    public void testSearch() {
        val searchResult = employeeDataStore.search("John");
        assertAndPrintTestCase("John", 2, searchResult.size());
    }

    @Test
    public void testSearchNoMatch() {
        val searchResult = employeeDataStore.search("Michael");
        assertAndPrintTestCase("Michael", 0, searchResult.size());
    }

    private void assertAndPrintTestCase(final Object input, final int actualOutput, final int expectedOutput) {
        assertEquals(expectedOutput, actualOutput);
        System.out.println("Input           : " + input);
        System.out.println("Actual Output   : " + actualOutput);
        System.out.println("Expected Output : " + expectedOutput);
        System.out.println();
    }

    @SneakyThrows
    private void populateEmployeeDataStore() {
        employeeDataStore.addEmployee(Employee.builder()
            .name("John")
            .age(25)
            .department("Engineering")
            .build());

        employeeDataStore.addEmployee(Employee.builder()
            .name("John")
            .age(35)
            .department("Finance")
            .build());

        employeeDataStore.addEmployee(Employee.builder()
            .name("Tyler")
            .age(30)
            .department("Engineering")
            .build());
    }
}
