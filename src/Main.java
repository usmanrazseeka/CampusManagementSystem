import java.util.Scanner;
import model.Student;
import structures.StudentLinkedList;
import structures.ActionStack;
import structures.ServiceQueue;
import structures.StudentBST;
import structures.StudentHashTable;
import structures.CampusGraph;

public class Main {

    static StudentLinkedList studentList = new StudentLinkedList();
    static ActionStack actionStack = new ActionStack();
    static ServiceQueue serviceQueue = new ServiceQueue();
    static StudentBST studentBST = new StudentBST();
    static StudentHashTable studentHashTable = new StudentHashTable();
    static CampusGraph campusGraph = new CampusGraph();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1: addStudent(); break;
                case 2: updateStudent(); break;
                case 3: deleteStudent(); break;
                case 4: displayAllStudents(); break;
                case 5: addServiceRequest(); break;
                case 6: processNextRequest(); break;
                case 7: displayRecentActions(); break;
                case 8: displayBSTStudents(); break;
                case 9: searchStudentByHash(); break;
                case 10: addCampusLocation(); break;
                case 11: removeCampusLocation(); break;
                case 12: addCampusConnection(); break;
                case 13: removeCampusConnection(); break;
                case 14: displayCampusConnections(); break;
                case 15: traverseCampus(); break;
                case 16: System.out.println("Exiting... Bye!"); break;
                default: System.out.println("Invalid choice, try again.");
            }
        } while (choice != 16);

        sc.close();
    }

    static void printMenu() {
        System.out.println("\n===== University Student Record & Campus Route System =====");
        System.out.println("1.  Add Student Record");
        System.out.println("2.  Update Student Record");
        System.out.println("3.  Delete Student Record");
        System.out.println("4.  Display All Records (Linked List)");
        System.out.println("5.  Add Service Request to Queue");
        System.out.println("6.  Process Next Service Request");
        System.out.println("7.  Display Recent Actions (Stack)");
        System.out.println("8.  Display Students (BST/AVL)");
        System.out.println("9.  Search Student (Hashing)");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection/Road");
        System.out.println("13. Remove Campus Connection/Road");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus (BFS/DFS)");
        System.out.println("16. Exit");
    }

    static int readInt(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            sc.next();
            System.out.print(prompt);
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }

    static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextDouble()) {
            System.out.println("Please enter a valid number.");
            sc.next();
            System.out.print(prompt);
        }
        double val = sc.nextDouble();
        sc.nextLine();
        return val;
    }

    // ---------- Member 1: Linked List ----------
    static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Programme: ");
        String programme = sc.nextLine();
        double marks = readDouble("Enter Marks: ");
        Student student = new Student(id, name, programme, marks);
        studentList.addStudent(student);
        studentBST.insert(student);
        studentHashTable.insert(student);
        actionStack.pushAction("Added student: " + id);
    }

    static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = sc.nextLine();
        System.out.print("Enter new Name: ");
        String name = sc.nextLine();
        System.out.print("Enter new Programme: ");
        String programme = sc.nextLine();
        double marks = readDouble("Enter new Marks: ");
        studentList.updateStudent(id, name, programme, marks);
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine();
        Student removed = studentList.deleteStudent(id);
        if (removed != null) {
            studentHashTable.remove(id);
            actionStack.pushAction("Deleted student: " + id);
        }
    }

    static void displayAllStudents() {
        studentList.displayAll();
    }

    // ---------- Member 2: Stack & Queue ----------
    static void addServiceRequest() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Request Description: ");
        String desc = sc.nextLine();
        serviceQueue.addRequest(id, desc);
    }

    static void processNextRequest() {
        serviceQueue.processNext();
    }

    static void displayRecentActions() {
        actionStack.displayActions();
    }

    // ---------- Member 3: BST/AVL & Hashing ----------
    static void displayBSTStudents() {
        studentBST.displayInOrder();
    }

    static void searchStudentByHash() {
        System.out.print("Enter Student ID to search: ");
        String id = sc.nextLine();
        Student found = studentHashTable.search(id);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Student ID " + id + " not found.");
        }
    }

    // ---------- Member 4 (You): Graph ----------
    static void addCampusLocation() {
        System.out.print("Enter new location name: ");
        String location = sc.nextLine();
        campusGraph.addLocation(location);
    }

    static void removeCampusLocation() {
        System.out.print("Enter location name to remove: ");
        String location = sc.nextLine();
        campusGraph.removeLocation(location);
    }

    static void addCampusConnection() {
        System.out.print("Enter first location: ");
        String loc1 = sc.nextLine();
        System.out.print("Enter second location: ");
        String loc2 = sc.nextLine();
        campusGraph.addConnection(loc1, loc2);
    }

    static void removeCampusConnection() {
        System.out.print("Enter first location: ");
        String loc1 = sc.nextLine();
        System.out.print("Enter second location: ");
        String loc2 = sc.nextLine();
        campusGraph.removeConnection(loc1, loc2);
    }

    static void displayCampusConnections() {
        campusGraph.displayConnections();
    }

    static void traverseCampus() {
        System.out.print("Enter starting location: ");
        String start = sc.nextLine();
        System.out.print("Choose traversal - Enter 'B' for BFS or 'D' for DFS: ");
        String type = sc.nextLine().trim().toUpperCase();
        if (type.equals("B")) {
            campusGraph.bfsTraversal(start);
        } else if (type.equals("D")) {
            campusGraph.dfsTraversal(start);
        } else {
            System.out.println("Invalid choice. Please enter B or D.");
        }
    }
}