public class LinkedListStudent {

    // -------------------------------
    // Node class for Linked List
    // -------------------------------
    private class Node {
        Student data;   // CO2: Stores student object
        Node next;      // CO2: Pointer to next node

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;  // CO2: Head of linked list

    // -------------------------------
    // CO2: Insert student at end of linked list
    // -------------------------------
    public void insert(Student s) {
        Node newNode = new Node(s);
        if(head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Inserted into linked list: " + s.getName());
    }

    // -------------------------------
    // CO2: Traverse and display all students
    // -------------------------------
    public void traverse() {
        if(head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        System.out.println("Students in Linked List:");
        Node temp = head;
        while(temp != null) {
            temp.data.display();
            temp = temp.next;
        }
    }

    // -------------------------------
    // CO2: Search student by ID
    // -------------------------------
    public Student searchById(int id) {
        Node temp = head;
        while(temp != null) {
            if(temp.data.getId() == id) {
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }

    // -------------------------------
    // CO2: Delete student by ID
    // -------------------------------
    public boolean deleteById(int id) {
        if(head == null) return false;
        if(head.data.getId() == id) {
            head = head.next;
            return true;
        }
        Node temp = head;
        while(temp.next != null) {
            if(temp.next.data.getId() == id) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}