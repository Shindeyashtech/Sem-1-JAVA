Develop a program in Java to manage a university's faculty database. 
Design a base class named "Employee" with data members such as 
employee ID, name, and salary. Create derived classes named 
"Professor" and "Staff" inheriting from the Employee class. The 
Professor class should have additional data members such as department 
and research interests, while the Staff class should include details like 
designation and years of service. Implement methods to display the 
details of each employee type. Use polymorphism and exception 
handling concept in the program



import java.util.ArrayList;

abstract class Employee {
    private int employeeID;
    private String name;
    private double salary;

    public Employee(int employeeID, String name, double salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public abstract void displayDetails();
}

class Professor extends Employee {
    private String department;
    private String researchInterests;

    public Professor(int employeeID, String name, double salary, String department, String researchInterests) {
        super(employeeID, name, salary);
        this.department = department;
        this.researchInterests = researchInterests;
    }

    @Override
    public void displayDetails() {
        System.out.println("Professor Details:");
        System.out.println("ID: " + getEmployeeID());
        System.out.println("Name: " + getName());
        System.out.println("Salary: " + getSalary());
        System.out.println("Department: " + department);
        System.out.println("Research Interests: " + researchInterests);
    }
}

class Staff extends Employee {
    private String designation;
    private int yearsOfService;

    public Staff(int employeeID, String name, double salary, String designation, int yearsOfService) {
        super(employeeID, name, salary);
        this.designation = designation;
        this.yearsOfService = yearsOfService;
    }

    @Override
    public void displayDetails() {
        System.out.println("Staff Details:");
        System.out.println("ID: " + getEmployeeID());
        System.out.println("Name: " + getName());
        System.out.println("Salary: " + getSalary());
        System.out.println("Designation: " + designation);
        System.out.println("Years of Service: " + yearsOfService);
    }
}

public class UniversityDatabase {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Professor(101, "Dr. Smith", 120000, "Computer Science", "Artificial Intelligence"));
        employees.add(new Staff(201, "John Doe", 45000, "Clerk", 5));
        employees.add(new Professor(102, "Dr. Taylor", 110000, "Mathematics", "Graph Theory"));
        employees.add(new Staff(202, "Jane Roe", 48000, "Technician", 3));

        for (Employee employee : employees) {
            try {
                employee.displayDetails();
                System.out.println();
            } catch (Exception e) {
                System.out.println("An error occurred while displaying details: " + e.getMessage());
            }
        }
    }
}