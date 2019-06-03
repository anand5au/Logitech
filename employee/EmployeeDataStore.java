import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.val;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class EmployeeDataStore {

    // Getter is only used in unit tests.
    @Getter
    private final HashMap<String, Set<Employee>> employeeMap;

    // employeesCount is used only in the unit tests.
    @Getter
    private int employeesCount;

    /**
     * No argument constructor for initializing the employeeMap with no data
     */
    public EmployeeDataStore() {
        employeeMap = new HashMap<>();
        employeesCount = 0;
    }

    /**
     * Add the given Employee object to the employee data store.
     * @param employee Employee object to be added.
     * @throws DuplicateEntryException if the given employee is already present in the data store.
     */
    public void addEmployee(final Employee employee) throws DuplicateEntryException {
        if (employee == null) {
            return;
        }
        val name = employee.getName();
        if (employeeMap.containsKey(name)) {
            val employeeSet = employeeMap.get(name);

            // checking if an employee is already present
            if (employeeSet.contains(employee)) {
                throw new DuplicateEntryException("Employee already present");
            }
            employeeSet.add(employee);
            employeesCount++;
            return;
        }
        employeeMap.put(name, Sets.newHashSet(employee));
        employeesCount++;
    }

    /**
     * Returns a list of employee(s) who has the given name. An empty list is returned
     * if there are no employees with given name.
     * @param employeeName employee name to be searched.
     * @return list of employee(s).
     */
    public List<Employee> search(String employeeName) {
        if(employeeMap.containsKey(employeeName)) {
            return Lists.newArrayList(employeeMap.get(employeeName));
        }
        return Lists.newArrayList();

    }
}
