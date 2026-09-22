package structures;

import model.Student;

public class StudentLinkedList {

    // Node class for the linked list
    private class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public StudentLinkedList() {
        head = null;
    }

    // Add a new student record
    public boolean addStudent(Student student) {
        if (searchById(student.getStudentId()) != null) {
            System.out.println("Error: Student ID " + student.getStudentId() + " already exists!");
            return false;
        }
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Student added successfully!");
        return true;
    }

    // Search a student by ID (helper method, also used by hashing/BST later)
    public Student searchById(String studentId) {
        Node current = head;
        while (current != null) {
            if (current.data.getStudentId().equalsIgnoreCase(studentId)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    // Update an existing student's details
    public boolean updateStudent(String studentId, String name, String programme, double marks) {
        Student student = searchById(studentId);
        if (student == null) {
            System.out.println("Error: Student ID " + studentId + " not found!");
            return false;
        }
        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);
        System.out.println("Student updated successfully!");
        return true;
    }

    // Delete a student record; returns the removed Student (for the Stack/undo feature)
    public Student deleteStudent(String studentId) {
        if (head == null) {
            System.out.println("Error: No records to delete!");
            return null;
        }
        if (head.data.getStudentId().equalsIgnoreCase(studentId)) {
            Student removed = head.data;
            head = head.next;
            System.out.println("Student deleted successfully!");
            return removed;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.getStudentId().equalsIgnoreCase(studentId)) {
                Student removed = current.next.data;
                current.next = current.next.next;
                System.out.println("Student deleted successfully!");
                return removed;
            }
            current = current.next;

                    }
        System.out.println("Error: Student ID " + studentId + " not found!");
        return null;
    }

    // Display all student records
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\n--- All Student Records ---");
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}