import java.util.ArrayList;
import java.util.Scanner;

public class Astar {
    Graph graph; //object
    String start;;
    String end;

    public Integer costOfEdge(int heuristic, int value){
        return heuristic + value;
    }

    public void traceHelper(){
        Node sourceNode = graph.findNode(start);
        astar(sourceNode);
    }
    public void astar(Node sourcenode){
        ArrayList<Edge> edges = new ArrayList<>();
        ArrayList<Node> cost = new ArrayList<>();

        Node source = graph.findNode(start);
        Node destination = graph.findNode(end);

        //Adding the nodes that have same start point
        for(Edge edge : graph.edges){
            if(edge.start == source){
                edges.add(edge);
            }
        }

        for (Edge edge : edges){
            cost.add(new Node(edge.end.label, costOfEdge(edge.cost , edge.end.heuristic)));
        }

        int min = cost.get(0).heuristic;
        Node next = new Node("", 0);

        for (int i = 1; i < cost.size(); i++) {
            if (min > cost.get(i).heuristic){
                min = cost.get(i).heuristic;
                next = cost.get(i);
            }
        }
        astar(next);
    }
}
