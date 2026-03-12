public class Student {
    // -------------------------------
    // CO5, CO6: Student properties encapsulated
    // -------------------------------
    private int id;
    private String name;
    private int age;
    private String course;
    private double marks;

    // -------------------------------
    // CO5, CO6: Constructor to initialize student
    // -------------------------------
    public Student(int id, String name, int age, String course, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    // -------------------------------
    // CO5, CO6: Getters
    // -------------------------------
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }
    public double getMarks() { return marks; }

    // -------------------------------
    // CO5, CO6: Optional setters for updating student data
    // -------------------------------
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCourse(String course) { this.course = course; }
    public void setMarks(double marks) { this.marks = marks; }

    // -------------------------------
    // CO5, CO6: Display method for console output
    // -------------------------------
    public void display() {
        System.out.printf("%-5d %-15s %-5d %-15s %-7.2f%n", id, name, age, course, marks);
    }

    // -------------------------------
    // CO5, CO6: String representation of student
    // -------------------------------
    @Override
    public String toString() {
        return id + " | " + name + " | " + age + " | " + course + " | " + marks;
    }
}