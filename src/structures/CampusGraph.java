package structures;

import java.util.*;

public class CampusGraph {

    // Adjacency list: each location maps to a list of connected locations
    private Map<String, List<String>> adjList;

    public CampusGraph() {
        adjList = new HashMap<>();
    }

    // Add a new campus location (vertex)
    public void addLocation(String location) {
        if (adjList.containsKey(location)) {
            System.out.println("Error: Location '" + location + "' already exists!");
            return;
        }
        adjList.put(location, new ArrayList<>());
        System.out.println("Location '" + location + "' added successfully!");
    }

    // Remove a campus location and all its connections
    public void removeLocation(String location) {
        if (!adjList.containsKey(location)) {
            System.out.println("Error: Location '" + location + "' not found!");
            return;
        }
        adjList.remove(location);
        // Remove this location from every other location's connection list
        for (List<String> connections : adjList.values()) {
            connections.remove(location);
        }
        System.out.println("Location '" + location + "' removed successfully!");
    }

    // Add a connection (edge) between two locations - undirected
    public void addConnection(String loc1, String loc2) {
        if (!adjList.containsKey(loc1) || !adjList.containsKey(loc2)) {
            System.out.println("Error: One or both locations do not exist!");
            return;
        }
        if (adjList.get(loc1).contains(loc2)) {
            System.out.println("Error: Connection already exists!");
            return;
        }
        adjList.get(loc1).add(loc2);
        adjList.get(loc2).add(loc1);
        System.out.println("Connection added between '" + loc1 + "' and '" + loc2 + "'.");
    }

    // Remove a connection between two locations
    public void removeConnection(String loc1, String loc2) {
        if (!adjList.containsKey(loc1) || !adjList.containsKey(loc2)) {
            System.out.println("Error: One or both locations do not exist!");
            return;
        }
        adjList.get(loc1).remove(loc2);
        adjList.get(loc2).remove(loc1);
        System.out.println("Connection removed between '" + loc1 + "' and '" + loc2 + "'.");
    }

    // Display all locations and their connections
    public void displayConnections() {
        if (adjList.isEmpty()) {
            System.out.println("No campus locations found.");
            return;
        }
        System.out.println("\n--- Campus Network ---");
        for (String location : adjList.keySet()) {
            System.out.println(location + " -> " + adjList.get(location));
        }
    }

    // BFS traversal starting from a given location
    public void bfsTraversal(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Error: Location '" + start + "' not found!");
            return;
        }
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        System.out.print("\nBFS Traversal from '" + start + "': ");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");
            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // DFS traversal starting from a given location
    public void dfsTraversal(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Error: Location '" + start + "' not found!");
            return;
        }
        Set<String> visited = new LinkedHashSet<>();
        System.out.print("\nDFS Traversal from '" + start + "': ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(String current, Set<String> visited) {
        visited.add(current);
        System.out.print(current + " ");
        for (String neighbor : adjList.get(current)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public boolean hasLocation(String location) {
        return adjList.containsKey(location);
    }
}