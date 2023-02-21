package graph;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph {

    public static void main(String[] args) {
        GraphNode n0 = new GraphNode(0);
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);

        n0.adjacency.addAll(List.of(n1, n2));
        n1.adjacency.addAll(List.of(n2, n3, n4));
        n2.adjacency.addAll(List.of(n3));
        n3.adjacency.addAll(List.of(n4));

        boolean[] visited = new boolean[5];
        cloneGraph(n0, n0, new GraphNode(n0.key), visited);
    }
    private static void cloneGraph(GraphNode start, GraphNode oldNode, GraphNode newNode, boolean[] visited) {

        /*for(GraphNode currNode : oldNode.adjacency) {
            if(!visited[currNode.key] || (visited[currNode.key] && currNode.key != oldNode.key)) {
                cloneGraph(start, currNode, new GraphNode(currNode.key), visited);
            }

            visited[currNode.key] = true;
        }*/

        //for(Gr)
    }
}
