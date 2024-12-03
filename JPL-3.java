//Develop a program in Java for managing a student database system.
//Design a base class named "Student" with data members such as name,
//date of birth, blood group, and contact address. Another base class
//named "PhysicalAttributes" consists of data members for height and
//weight. Finally, a base class named "InsuranceInfo" holds the insurance
//policy number. The derived class "StudentRecord" contains additional
//data members for telephone numbers and driving license number.
//Implement a menu-driven program to perform operations such as
//building a master table, displaying records, inserting new entries,
//deleting entries, editing records, and searching for a specific record.
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    String dob;
    String bloodGroup;
    String contactAddress;

    public Student(String name, String dob, String bloodGroup, String contactAddress) {
        this.name = name;
        this.dob = dob;
        this.bloodGroup = bloodGroup;
        this.contactAddress = contactAddress;
    }
}

class PhysicalAttributes {
    double height;
    double weight;

    public PhysicalAttributes(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }
}

class InsuranceInfo {
    String insurancePolicyNumber;

    public InsuranceInfo(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }
}

class StudentRecord extends Student {
    PhysicalAttributes physicalAttributes;
    InsuranceInfo insuranceInfo;
    String telephoneNumber;
    String drivingLicenseNumber;

    public StudentRecord(String name, String dob, String bloodGroup, String contactAddress, double height, double weight, 
                         String insurancePolicyNumber, String telephoneNumber, String drivingLicenseNumber) {
        super(name, dob, bloodGroup, contactAddress);
        this.physicalAttributes = new PhysicalAttributes(height, weight);
        this.insuranceInfo = new InsuranceInfo(insurancePolicyNumber);
        this.telephoneNumber = telephoneNumber;
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public void displayRecord() {
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Contact Address: " + contactAddress);
        System.out.println("Height: " + physicalAttributes.height);
        System.out.println("Weight: " + physicalAttributes.weight);
        System.out.println("Insurance Policy Number: " + insuranceInfo.insurancePolicyNumber);
        System.out.println("Telephone Number: " + telephoneNumber);
        System.out.println("Driving License Number: " + drivingLicenseNumber);
    }
}

public class StudentDatabase {
    private static final ArrayList<StudentRecord> records = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Student Database System ===");
            System.out.println("1. Build Master Table");
            System.out.println("2. Display Records");
            System.out.println("3. Insert New Entry");
            System.out.println("4. Delete Entry");
            System.out.println("5. Edit Record");
            System.out.println("6. Search Record");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    buildMasterTable();
                    break;
                case 2:
                    displayRecords();
                    break;
                case 3:
                    insertEntry();
                    break;
                case 4:
                    deleteEntry();
                    break;
                case 5:
                    editRecord();
                    break;
                case 6:
                    searchRecord();
                    break;
                case 7:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void buildMasterTable() {
        System.out.print("Enter number of records to add: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            records.add(createRecord());
        }
    }

    private static void displayRecords() {
        if (records.isEmpty()) {
            System.out.println("No records to display.");
            return;
        }
        for (StudentRecord record : records) {
            System.out.println("\n--- Student Record ---");
            record.displayRecord();
        }
    }

    private static void insertEntry() {
        records.add(createRecord());
        System.out.println("Record inserted successfully.");
    }

    private static void deleteEntry() {
        System.out.print("Enter name of the student to delete: ");
        String name = scanner.nextLine();
        records.removeIf(record -> record.name.equalsIgnoreCase(name));
        System.out.println("Record deleted successfully, if found.");
    }

    private static void editRecord() {
        System.out.print("Enter name of the student to edit: ");
        String name = scanner.nextLine();
        for (StudentRecord record : records) {
            if (record.name.equalsIgnoreCase(name)) {
                System.out.println("Editing record for " + name);
                StudentRecord updatedRecord = createRecord();
                records.set(records.indexOf(record), updatedRecord);
                System.out.println("Record updated successfully.");
                return;
            }
        }
        System.out.println("Record not found.");
    }

    private static void searchRecord() {
        System.out.print("Enter name of the student to search: ");
        String name = scanner.nextLine();
        for (StudentRecord record : records) {
            if (record.name.equalsIgnoreCase(name)) {
                System.out.println("\n--- Student Record Found ---");
                record.displayRecord();
                return;
            }
        }
        System.out.println("Record not found.");
    }

    private static StudentRecord createRecord() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Date of Birth (dd/mm/yyyy): ");
        String dob = scanner.nextLine();
        System.out.print("Enter Blood Group: ");
        String bloodGroup = scanner.nextLine();
        System.out.print("Enter Contact Address: ");
        String contactAddress = scanner.nextLine();
        System.out.print("Enter Height (in cm): ");
        double height = scanner.nextDouble();
        System.out.print("Enter Weight (in kg): ");
        double weight = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Insurance Policy Number: ");
        String insurancePolicyNumber = scanner.nextLine();
        System.out.print("Enter Telephone Number: ");
        String telephoneNumber = scanner.nextLine();
        System.out.print("Enter Driving License Number: ");
        String drivingLicenseNumber = scanner.nextLine();
        return new StudentRecord(name, dob, bloodGroup, contactAddress, height, weight, 
                                 insurancePolicyNumber, telephoneNumber, drivingLicenseNumber);
    }
}
