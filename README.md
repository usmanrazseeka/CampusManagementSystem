# University Student Record and Campus Route Management System

## Module: CIT300 - Data Structures and Algorithms
## Assignment: Graded Practical Assignment 1 (Week 10)

## Project Overview
This is a Java console application that manages university student records and represents
connections between campus locations. It demonstrates the practical use of linked lists,
stacks, queues, trees (BST), hashing, and graphs.

## Group Members and Responsibilities

| Name              | Student ID   | Responsibility                          |
|-------------------|--------------|------------------------------------------|
| Fathima Sahani    | 23DA2-0924   | Linked List (Student Record Management) |
| Fathima Simrana   | 23DA2-0665   | Stack and Queue (Actions & Service Requests) |
| Fathima Afra      | 23DA2-1145   | BST and Hashing (Search Functionality)  |
| Fathima Razeeka   | 23DA2-0976   | Graph Implementation (Campus Locations & Routes) |

All members contributed to integration, testing, debugging, documentation, and GitHub collaboration.

## Features Implemented

### Student Record Management (Linked List)
- Add, Update, Delete, and Display student records
- Duplicate Student ID validation

### Stack and Queue
- Stack tracks recent actions (add/delete history)
- Queue manages service requests in FIFO order

### BST and Hashing
- BST organizes and displays students sorted by Student ID
- Hashing provides fast O(1) lookup by Student ID

### Graph (Campus Route Management)
- Add/Remove campus locations (vertices)
- Add/Remove connections/roads (edges) using an adjacency list
- Display the full campus network
- BFS and DFS traversal from any starting location

## How to Run
1. Open the project folder in VS Code or IntelliJ IDEA
2. Navigate to `src/Main.java`
3. Run `Main.java`
4. Follow the on-screen menu (options 1-16)

## Menu Options
1. Add Student Record
2. Update Student Record
3. Delete Student Record
4. Display All Records (Linked List)
5. Add Service Request to Queue
6. Process Next Service Request
7. Display Recent Actions (Stack)
8. Display Students (BST)
9. Search Student (Hashing)
10. Add Campus Location
11. Remove Campus Location
12. Add Campus Connection/Road
13. Remove Campus Connection/Road
14. Display Campus Connections
15. Traverse Campus (BFS/DFS)
16. Exit
