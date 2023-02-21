package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    int key;
    List<GraphNode> adjacency = new ArrayList<>();

    public GraphNode(int key) {
        this.key = key;
    }
}
