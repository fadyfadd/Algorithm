package algo.trees;
import java.util.ArrayList;
import java.util.List;

import algo.Utilities;

public class SerializeDeserializePreOrder {

    public static void main(String... args) {

        Node root = new Node("10");
        root.left = new Node("20");
        root.right = new Node("30");
        root.left.left = new Node("40");
        root.left.right = new Node("60");

        var nodeList = serialize(root);
        System.out.println(nodeList);
        Utilities.printInOrder(deserialize(nodeList)); 
    }

    private static void _serialize(Node node, List<String> output) {

        if (node == null) {
            output.add("/");
            return;
        }


        output.add(node.data);
        _serialize(node.left, output);
        _serialize(node.right, output);
    }

    private static List<String> serialize(Node list) {
        List<String> output = new ArrayList<>();
        _serialize(list, output);
        return output;
    }

    private static Node _deserialize(List<String> list, int[] i) {
        if (list.get(i[0]) == "/") {
            i[0]++;
            return null;
        }

        Node node = new Node(list.get(i[0]));
        i[0]++;

        node.left = _deserialize(list, i);
        node.right = _deserialize(list, i);

        return node;

    }

    private static Node deserialize(List<String> list) {
        int[] i = {0};
        return _deserialize(list, i);
    }


}
