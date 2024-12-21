package algo.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Map<String, ArrayList<Node>> content = new HashMap<>();

    public void addVertex(String vertex) {
        content.put(vertex , new ArrayList<Node>());
    }

    public void addEdge(String vertex , Node edge) {
        content.get(vertex).add(edge);
    }

    public Map<String, ArrayList<Node>> getContent() {
        return content;
    }
}
