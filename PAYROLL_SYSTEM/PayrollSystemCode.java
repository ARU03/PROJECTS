package PAYROLL;

import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    // Constructor to initialize the instance variables
    public Employee(String name, int id) {

        // this keyword is used to refer to the current object
        this.name = name;
        this.id = id;
    }

    // Getter methods to access the private instance variables
    public String getName() {
        return name;
    }

    // Getter method to access the private instance variable
    public int getId() {
        return id;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();

    // Override the toString method
    @Override
    public String toString() {
        return "Employee [ Name = " + name + ", Id = " + id + ", Salary = " + calculateSalary() + " ]";
    }
}

class FullTimeEmployee extends Employee {
    // Instance variables
    private double monthlySalary;

    // Constructor to initialize the instance variables
    public FullTimeEmployee(String Name, int Id, double monthlySalary) {
        super(Name, Id);
        this.monthlySalary = monthlySalary;
    }

    // override is used to provide the specific implementation of the method that is
    // already provided by its superclass
    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Implement the calculateSalary method
    @Override

    // Calculate the salary for a PartTimeEmployee
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem {
    private ArrayList<Employee> employeeList;

    // Constructor to initialize the employeeList
    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    // Add an employee to the PayrollSystem
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {

        // Find the employee with the given id
        Employee employeeToRemove = null;

        // Enhanced for loop to iterate over the employeeList
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }

        // Remove the employee from the list
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    // Display the details of all employees in the PayrollSystem
    public void displayEmployees() {

        // Enhanced for loop to iterate over the employeeList
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    // Getter is not required for this example
    // Getter is used to access the private instance variable from another class
    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    // Setter is not required for this example
    // employeeList is initialized in the constructor and modified using addEmployee
    // and removeEmployee methods
    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}

public class PayrollSystemCode {
    public static void main(String[] args) {

        // Create an instance of PayrollSystem

        PayrollSystem payrollSystem = new PayrollSystem();

        // Create instances of FullTimeEmployee and PartTimeEmployee

        FullTimeEmployee emp1 = new FullTimeEmployee("John Doe", 101, 5000.0);
        FullTimeEmployee emp2 = new FullTimeEmployee("Jane Smith", 105, 450.0);
        FullTimeEmployee emp3 = new FullTimeEmployee("Steve Rogers", 102, 6000.0);

        PartTimeEmployee emp4 = new PartTimeEmployee("Jane Smith", 106, 30, 15.0);
        PartTimeEmployee emp5 = new PartTimeEmployee("Peter Parker", 103, 20, 20.0);
        PartTimeEmployee emp6 = new PartTimeEmployee("Lara Croft", 104, 25, 18.0);

        // Add the employees to the PayrollSystem
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        payrollSystem.addEmployee(emp4);
        payrollSystem.addEmployee(emp5);
        payrollSystem.addEmployee(emp6);

        // Display the employee details
        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();

        // Remove an employee from the PayrollSystem
        System.out.println("\nRemoving the Employee Detail...");
        payrollSystem.removeEmployee(101);
        payrollSystem.removeEmployee(102);

        // Display the remaining employee details
        System.out.println("\nAfter Remove Remaining Employee Details :: ");
        payrollSystem.displayEmployees();

        /*
         *****************************************************************************************
         *********************************** Output **********************************************
         *****************************************************************************************
         * 
         * ------------->> Initial Employee Details <<----------------
         * 
         * Employee [name=John Doe, id=101, salary=5000.0]
         * Employee [name=Jane Smith, id=105, salary=450.0]
         * Employee [name=Steve Rogers, id=102, salary=6000.0]
         * Employee [name=Jane Smith, id=106, salary=450.0]
         * Employee [name=Peter Parker, id=103, salary=400.0]
         * Employee [name=Lara Croft, id=104, salary=450.0]
         * 
         * ------->> After Remove Remaining Employee Details <<--------
         * 
         * The output shows the details of the employees in the PayrollSystem before and
         * after removing employees.
         * The employees with id 101 (John Doe) and id 102 (Steve Rogers) are removed
         * from the PayrollSystem.
         * The remaining employee details are displayed after removing the employees.
         * The output confirms that the employees with id 101 and id 102 are no longer
         * present in the
         * PayrollSystem.
         * The PayrollSystem class contains methods to add and remove employees, as well
         * as display the details of all employees.
         * The main method creates instances of FullTimeEmployee and PartTimeEmployee,
         * adds them to the PayrollSystem, and displays the employee details.
         * The removeEmployee method removes an employee from the PayrollSystem based on
         * the employee id.
         * The displayEmployees method prints the details of all employees in the
         * PayrollSystem.
         * The output confirms that the employees with id 101 and id 102 are
         * successfully removed
         * from the PayrollSystem.
         */
    }
}
