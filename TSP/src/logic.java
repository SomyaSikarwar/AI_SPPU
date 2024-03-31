import java.util.ArrayList;

public class logic {

    public void createAllPossiblePaths(int[][] matt){
        for (int i = 0; i < matt.length; i++) {
            tsp(matt, i);
        }
    }

    public void tsp(int[][] matt, int startNode) {
        int numNodes = matt.length;
        ArrayList<Integer> visitedNodes = new ArrayList<>();
        int[] route = new int[numNodes + 1];
        route[0] = startNode ;
        visitedNodes.add(startNode);

        int currentNode = startNode;
        int totalCost = 0;
        while (visitedNodes.size() < numNodes) {
            int nextNode = -1;
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i < numNodes; i++) {
                if (!visitedNodes.contains(i) && matt[currentNode][i] != -1 && matt[currentNode][i] < minCost) {
                    minCost = matt[currentNode][i];
                    nextNode = i;
                }
            }
            if (nextNode != -1) {
                visitedNodes.add(nextNode);
                route[visitedNodes.size() - 1] = nextNode;
                totalCost += minCost;
                currentNode = nextNode;
            } else {

                break;
            }
        }

        // Add return to the start node
        route[route.length - 1] = startNode;
        totalCost += matt[currentNode][startNode]; // Cost to return to start node

        // Print the route
        System.out.println("TSP Route:");
        for (int i = 0; i < route.length; i++) {
            System.out.print(route[i] + " ");
        }
        System.out.println();
        System.out.println("Total Cost: " + totalCost);
    }
}