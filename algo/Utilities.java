package algo;
import java.util.Arrays;
 

public class Utilities {

    public static void printInOrder(Node root) {
        if (root == null) return;

        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }
    
    public static  <T> void printArray(T[] arr) {
        Arrays.stream(arr).forEach((value)->System.out.println(value));
    }
}
