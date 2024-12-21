package algo.common;
public class Node {
    public String data;
    public Node left, right;
    public Long weight;

    public Node (String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node(String data , Long weight) {
        this.data = data;
        this.weight = weight;
        this.left = null;
        this.right = null;
    }
}