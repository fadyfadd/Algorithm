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
    Map<String, String> previous;
    Map<String, Long> distance;

    public void DijkstraPath(String start, String finish, Graph graph) {
        dijkstraQueue = new DijkstraQueue();
        path = new ArrayList<>();
        previous = new HashMap<>();
        distance = new HashMap<>();

        var entrySet = graph.getContent().entrySet().iterator();

        while (entrySet.hasNext()) {
            var key = entrySet.next().getKey();

            if (key == start) {
                distance.put(key, 0L);
                dijkstraQueue.put(new PriorityItem(key, 0L));
            } else {
                distance.put(key, Long.MAX_VALUE);
                dijkstraQueue.put(new PriorityItem(key, Long.MAX_VALUE));
            }

            previous.put(key, null);
        }

        while (dijkstraQueue.contains()) {

            var currentNode = dijkstraQueue.getPriorityNode();

            if (currentNode.item == finish) {
                while (previous.get(currentNode.item) != null) {
                    path.add(currentNode.item);
                    currentNode.item = previous.get(currentNode.item);
                }
                break;
            }

            if (currentNode.weight != Long.MAX_VALUE) {

                var children = graph.getContent().get(currentNode.item);
                for (int i = 0; i <= children.size() - 1; i++) {

                    var newWeight = children.get(i).weight + currentNode.weight;
                    var currentWeight = distance.get(children.get(i));

                    if (newWeight < currentWeight) {
                        distance.put(children.get(i).data, newWeight);
                        previous.put(children.get(i).data, currentNode.item);
                        dijkstraQueue.put(new PriorityItem(children.get(i).data, newWeight));
                    }
                }
            }
        }

        path.add(start);
        path = path.reversed();
        shortestDistance = distance.get(finish);
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

        var inst = new Dijkstra();
        inst.DijkstraPath("A" , "E" , graph);
        inst.path.stream().forEach((a)->System.out.print(a + " "));
        System.out.println(inst.shortestDistance);

    }

}
