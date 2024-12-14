import java.util.ArrayList;
import java.util.List;

public class FindAllPaths {

    private static void _findAllPaths(List<Node> currentPath, List<List<Node>> paths, Node currentNode) {

        if (currentNode == null) {
            return;
        }

        currentPath.add(currentNode);

        if (currentNode.left == null && currentNode.right == null) {
            paths.add(new ArrayList<Node>(currentPath));
        } else {
            _findAllPaths(currentPath, paths, currentNode.left);
            _findAllPaths(currentPath, paths, currentNode.right);
        }

        currentPath.remove(currentPath.size() - 1);
    }

    private static List<List<Node>> findAllPaths(Node head) {
        List<List<Node>> paths = new ArrayList<>();
        List<Node> currentPath = new ArrayList<>();
        _findAllPaths(currentPath, paths, head);
        return paths;
    }
    public static void main(String... args) {

        Node root = new Node("10");
        root.left = new Node("8");
        root.right = new Node("2");
        root.left.left = new Node("3");
        root.left.right = new Node("5");
        root.right.left = new Node("2");

        var output = findAllPaths(root);
        
        output.stream().forEach((l) -> {
            System.out.println("Path");
            l.stream().forEach((n) -> {
                System.out.println(n.data);
            });
        });     

    }
}
