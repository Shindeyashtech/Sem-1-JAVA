//Design and implement a class concept with default, parameterized, andcopy constructors, along with member functions to accept and display information.
public class Student {
    private int id;
    private String name;
    private float marks;

    public Student() {
        this.id = 0;
        this.name = "Unknown";
        this.marks = 0.0f;
    }

    public Student(int id, String name, float marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public Student(Student other) {
        this.id = other.id;
        this.name = other.name;
        this.marks = other.marks;
    }

    public void setInfo(int id, String name, float marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }

    public static void main(String[] args) {
        Student student1 = new Student();
        System.out.println("Default Constructor:");
        student1.displayInfo();

        Student student2 = new Student(1, "John Doe", 85.5f);
        System.out.println("\nParameterized Constructor:");
        student2.displayInfo();

        Student student3 = new Student(student2);
        System.out.println("\nCopy Constructor:");
        student3.displayInfo();

        student1.setInfo(2, "Jane Smith", 90.0f);
        System.out.println("\nAfter Setting Info:");
        student1.displayInfo();
    }
}
