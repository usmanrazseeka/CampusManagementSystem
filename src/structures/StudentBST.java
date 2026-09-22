package structures;

import model.Student;

public class StudentBST {

    private class Node {
        Student data;
        Node left, right;

        Node(Student data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    public StudentBST() {
        root = null;
    }

    // Insert a student into the BST, keyed by Student ID
    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private Node insertRec(Node root, Student student) {
        if (root == null) {
            return new Node(student);
        }
        int cmp = student.getStudentId().compareTo(root.data.getStudentId());
        if (cmp < 0) {
            root.left = insertRec(root.left, student);
        } else if (cmp > 0) {
            root.right = insertRec(root.right, student);
        }
        // if cmp == 0 (duplicate ID), do nothing - LinkedList already prevents duplicates
        return root;
    }

    // Search a student by ID
    public Student search(String studentId) {
        return searchRec(root, studentId);
    }

    private Student searchRec(Node root, String studentId) {
        if (root == null) return null;
        int cmp = studentId.compareTo(root.data.getStudentId());
        if (cmp == 0) return root.data;
        else if (cmp < 0) return searchRec(root.left, studentId);
        else return searchRec(root.right, studentId);
    }

    // In-order traversal - displays students sorted by Student ID
    public void displayInOrder() {
        if (root == null) {
            System.out.println("No student records in BST.");
            return;
        }
        System.out.println("\n--- Students (sorted by ID via BST) ---");
        inOrderRec(root);
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.data);
            inOrderRec(node.right);
        }
    }
}