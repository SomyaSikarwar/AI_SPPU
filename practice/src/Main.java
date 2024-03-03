import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph myGraph = new Graph();
        myGraph.addNode("S", 3);
        myGraph.addNode("A", 2);
        myGraph.addNode("B", 1);
        myGraph.addNode("G", 0);

        myGraph.addEdge("A", "G", 2);
        myGraph.addEdge("B", "G", 3);
        myGraph.addEdge("S", "A", 2);
        myGraph.addEdge("S", "B", 2);

        Astar astar = new Astar();
        astar.traceHelper();


    }
}