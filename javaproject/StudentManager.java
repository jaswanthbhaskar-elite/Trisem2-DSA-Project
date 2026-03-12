import java.util.*;

public class StudentManager {

    // -------------------------------
    // CO5, CO6: Main student storage
    // -------------------------------
    private ArrayList<Student> students = new ArrayList<>();
    private LinkedListStudent linkedList = new LinkedListStudent(); // CO2: custom linked list

    // -------------------------------
    // CO3: Advanced data structures
    // -------------------------------
    private Stack<Student> undoStack = new Stack<>();                    // Undo last add
    private Queue<Student> enrollmentQueue = new LinkedList<>();         // Queue for enrollment
    private PriorityQueue<Student> topStudents = new PriorityQueue<>(
        Comparator.comparingDouble(Student::getMarks).reversed()
    );                                                                   // PriorityQueue by marks

    // -------------------------------
    // CO4: HashMap for fast ID lookup
    // -------------------------------
    private HashMap<Integer, Student> studentMap = new HashMap<>();

    // -------------------------------
    // CO5, CO6: Add student to all structures
    // -------------------------------
    public void addStudent(Student s) {
        students.add(s);
        linkedList.insert(s);
        undoStack.push(s);
        enrollmentQueue.add(s);
        topStudents.add(s);
        studentMap.put(s.getId(), s);
        System.out.println("Student added successfully!");
    }

    // -------------------------------
    // CO3: Undo last added student using Stack
    // -------------------------------
    public void undoLastAdd() {
        if(!undoStack.isEmpty()) {
            Student last = undoStack.pop();
            students.remove(last);
            enrollmentQueue.remove(last);
            topStudents.remove(last);
            studentMap.remove(last.getId());
            linkedList.deleteById(last.getId());
            System.out.println("Undo successful: " + last.getName());
        } else {
            System.out.println("No operations to undo!");
        }
    }

    // -------------------------------
    // CO3: Process next student using Queue
    // -------------------------------
    public void processNextStudent() {
        if(!enrollmentQueue.isEmpty()) {
            Student s = enrollmentQueue.poll();
            System.out.println("Processing student: ");
            s.display();
        } else {
            System.out.println("No students in the queue.");
        }
    }

    // -------------------------------
    // CO3: View top student using PriorityQueue
    // -------------------------------
    public void viewTopStudent() {
        if(!topStudents.isEmpty()) {
            System.out.println("Top student: ");
            topStudents.peek().display();
        } else {
            System.out.println("No students yet.");
        }
    }

    // -------------------------------
    // CO5: View all students
    // -------------------------------
    public void viewStudents() {
        if(students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.printf("%-5s %-15s %-5s %-15s %-7s%n", "ID", "Name", "Age", "Course", "Marks");
        for(Student s : students) {
            s.display();
        }
    }

    // -------------------------------
    // CO4: Search student by ID (HashMap)
    // -------------------------------
    public void searchStudent(int id) {
        if(studentMap.containsKey(id)) {
            studentMap.get(id).display();
        } else {
            System.out.println("Student not found.");
        }
    }

    // -------------------------------
    // CO1: Bubble Sort students by marks
    // -------------------------------
    public void bubbleSortByMarks() {
        int n = students.size();
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {
                if(students.get(j).getMarks() > students.get(j+1).getMarks()) {
                    Collections.swap(students, j, j+1);
                }
            }
        }
        System.out.println("Students sorted by marks (Bubble Sort).");
    }

    // -------------------------------
    // CO1: Binary Search by ID
    // -------------------------------
    public void binarySearchById(int id) {
        students.sort(Comparator.comparingInt(Student::getId)); // ensure sorted
        int left = 0, right = students.size() - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            int midId = students.get(mid).getId();
            if(midId == id) {
                System.out.println("Student found:");
                students.get(mid).display();
                return;
            } else if(midId < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Student not found.");
    }
}