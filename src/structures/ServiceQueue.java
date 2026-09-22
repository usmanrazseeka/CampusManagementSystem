package structures;

import model.Student;
import java.util.LinkedList;
import java.util.Queue;

public class ServiceQueue {

    private Queue<String> requestQueue;

    public ServiceQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add a service request (student ID with request description)
    public void addRequest(String studentId, String requestDescription) {
        String request = studentId + " - " + requestDescription;
        requestQueue.offer(request);
        System.out.println("Service request added: " + request);
    }

    // Process (remove) the next request in FIFO order
    public void processNext() {
        if (requestQueue.isEmpty()) {
            System.out.println("No pending service requests.");
            return;
        }
        String processed = requestQueue.poll();
        System.out.println("Processed request: " + processed);
    }

    public boolean isEmpty() {
        return requestQueue.isEmpty();
    }

    public int size() {
        return requestQueue.size();
    }
}