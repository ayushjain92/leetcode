package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public static class Node {
        int key;
        List<Node> adjacency = new ArrayList<>();

        public Node(int key) {
            this.key = key;
        }
    }

    public static void main(String args[]) {
        // Creating graph
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n0.adjacency.addAll(List.of(n1, n2));
        n1.adjacency.addAll(List.of(n2, n3, n4));
        n2.adjacency.addAll(List.of(n3));
        n3.adjacency.addAll(List.of(n4));

    }

}
