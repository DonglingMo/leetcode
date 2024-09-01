package business.cases;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {
    private final Map<Integer, LinkedList<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new LinkedList<>());
    }

    public void addEdge(int source, int destination) {
        adjacencyList.putIfAbsent(source, new LinkedList<>());
        adjacencyList.putIfAbsent(destination, new LinkedList<>());
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // For undirected graph
    }

    public LinkedList<Integer> getAdjacencyList(int vertex) {
        return adjacencyList.get(vertex);
    }
}
