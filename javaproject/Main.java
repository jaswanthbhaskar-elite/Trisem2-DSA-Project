import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // -------------------------------
        // CO6: Program entry & user interaction
        // CO5: Application-level CRUD menu
        // -------------------------------
        try (Scanner sc = new Scanner(System.in)) {

            StudentManager manager = new StudentManager();

            while(true) {
                // -------------------------------
                // Menu Display
                // CO5: Provides options for all operations
                // CO3: Stack, Queue, PriorityQueue operations included
                // -------------------------------
                System.out.println("\n--- Student Management System ---");
                System.out.println("1. Add Student");                    // CO5, CO6
                System.out.println("2. View Students");                  // CO5
                System.out.println("3. Search Student");                 // CO4 (HashMap lookup)
                System.out.println("4. Sort Students");                  // CO1 (Bubble Sort)
                System.out.println("5. Undo Last Add (Stack)");          // CO3 (Stack)
                System.out.println("6. Process Next Student (Queue)");   // CO3 (Queue)
                System.out.println("7. View Top Student (PriorityQueue)");// CO3 (PriorityQueue)
                System.out.println("8. Exit");                           // CO6
                System.out.print("Enter choice: ");

                int choice;
                if(sc.hasNextInt()) {
                    choice = sc.nextInt();
                    sc.nextLine();
                } else {
                    System.out.println("Invalid input!");
                    sc.nextLine();
                    continue;
                }

                // -------------------------------
                // CO6: Switch-case invokes StudentManager operations
                // -------------------------------
                switch(choice) {
                    case 1:
                        // -------------------------------
                        // CO5, CO6: Add student (CRUD operation)
                        // -------------------------------
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Age: ");
                        int age = sc.nextInt(); sc.nextLine();
                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();
                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble(); sc.nextLine();

                        manager.addStudent(new Student(id, name, age, course, marks));
                        break;

                    case 2:
                        // -------------------------------
                        // CO5: View all students
                        // -------------------------------
                        manager.viewStudents();
                        break;

                    case 3:
                        // -------------------------------
                        // CO4: Search using HashMap
                        // -------------------------------
                        System.out.print("Enter student ID to search: ");
                        if(sc.hasNextInt()) {
                            int searchId = sc.nextInt(); sc.nextLine();
                            manager.searchStudent(searchId);
                        } else {
                            System.out.println("Invalid ID!");
                            sc.nextLine();
                        }
                        break;

                    case 4:
                        // -------------------------------
                        // CO1: Bubble Sort implementation
                        // -------------------------------
                        manager.bubbleSortByMarks();
                        break;

                    case 5:
                        // -------------------------------
                        // CO3: Undo using Stack
                        // -------------------------------
                        manager.undoLastAdd();
                        break;

                    case 6:
                        // -------------------------------
                        // CO3: Process students in Queue order
                        // -------------------------------
                        manager.processNextStudent();
                        break;

                    case 7:
                        // -------------------------------
                        // CO3: View top student using PriorityQueue
                        // -------------------------------
                        manager.viewTopStudent();
                        break;

                    case 8:
                        // -------------------------------
                        // CO6: Exit program
                        // -------------------------------
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}