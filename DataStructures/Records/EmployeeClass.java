package DataStructures.Records;

import java.util.Objects;

public class EmployeeClass {
    private final String name;
    private final int employeeNumber;

    public EmployeeClass(String name, int employeeNumber) {
        this.name = name;
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    @Override
    public String toString() {
        return "EmployeeClass(name=" + this.getName() + ", employeeNumber=" + this.getEmployeeNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, employeeNumber);
    }

    @Override
    public boolean equals(final Object obj) {
        if(this == obj) return true;

        if (obj == null) return false;

        if(getClass() != obj.getClass()) return false;

        EmployeeClass employee = (EmployeeClass) obj;

        return Objects.equals(employeeNumber, employee.employeeNumber)
                && Objects.equals(name, employee.name);
    }

}
