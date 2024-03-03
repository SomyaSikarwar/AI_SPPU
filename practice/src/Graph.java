import java.util.*;

public class Graph {
    public List<Node> nodes = new ArrayList<>();
    public List<Edge> edges = new ArrayList<>();

    public void addNode(String label , Integer value){
        Node newNode = new Node(label,value);
        nodes.add(newNode);
    }

    public void addEdge(String start , String end , Integer heuristic){
        Node startNode = findNode(start);
        Node endNode = findNode(end);
        if(startNode != null && endNode != null) {
            Edge newEdge = new Edge(startNode, endNode, heuristic);
            edges.add(newEdge);
        }
        else{
            System.out.println("Vertices not found");
        }
    }

    public Node findNode(String label) {
        for (Node node : nodes) {
            if (node.label.equals(label)) {
                return node;
            }
        }
        return null;
    }
}

class Node {
    String label;
    int heuristic;

    public Node(String label, int value) {
        this.label = label;
        this.heuristic = value;
    }
}

class Edge{
    Node start;
    Node end;
    int cost;

    public Edge(Node start, Node end, int cost){
        this.start = start;
        this.end = end ;
        this.cost = cost;
    }

}


