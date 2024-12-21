package algo;

import algo.common.Graph;
import algo.common.Node;

import java.util.*;

public class Dijkstra {

    class PriorityItem {
        String item;
        Long weight;

        public PriorityItem(String item, Long weight) {
            this.item = item;
            this.weight = weight;
        }
    }

    class DijkstraQueue {
        private List<PriorityItem> nodes = new ArrayList<PriorityItem>();

        public boolean contains() {
            return nodes.size() > 0;
        }

        public void put(PriorityItem item) {

            nodes.add(item);
            nodes.sort(new Comparator<PriorityItem>() {
                @Override
                public int compare(PriorityItem o1, PriorityItem o2) {
                    return (int) (o1.weight - o2.weight);
                }
            });

        }

        public PriorityItem getPriorityNode() {
            return nodes.get(0);
        }
    }

    public List<String> path = null;
    public Long shortestDistance = -1L;
    private DijkstraQueue dijkstraQueue = null;
    Map<String , String> previous;
    Map<String , Long> distance;

    public void DijkstraPath(String start, String finish, Graph graph) {
        dijkstraQueue = new DijkstraQueue();
        path = new ArrayList<>();
        previous = new HashMap<>();
        distance = new HashMap<>();
    }

    public static void main(String... args) {

        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", new Node("B", 4L));
        graph.addEdge("A", new Node("C", 2L));
        graph.addEdge("B", new Node("E", 3L));
        graph.addEdge("C", new Node("D", 2L));
        graph.addEdge("C", new Node("F", 4L));
        graph.addEdge("D", new Node("E", 3L));
        graph.addEdge("D", new Node("F", 1L));
        graph.addEdge("E", new Node("F", 1L));

    }

}
