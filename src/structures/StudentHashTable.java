package structures;

import model.Student;
import java.util.HashMap;

public class StudentHashTable {

    private HashMap<String, Student> table;

    public StudentHashTable() {
        table = new HashMap<>();
    }

    public void insert(Student student) {
        table.put(student.getStudentId(), student);
    }

    public Student search(String studentId) {
        return table.get(studentId);
    }

    public void remove(String studentId) {
        table.remove(studentId);
    }

    public boolean contains(String studentId) {
        return table.containsKey(studentId);
    }
}