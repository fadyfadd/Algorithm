package algo.common;

import java.util.Arrays;


public class Utilities {

    public static void printMatrix(long[][] matrix) {
        for (int i = 0 ; i <= matrix.length - 1 ; i++) {
            for (int j = 0 ; j <= matrix[i].length - 1 ; j++) {
              System.out.print(String.valueOf(matrix[i][j]) + " ");
            }
            System.out.println("");
        }
    }

    public static void printPreOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    
    public static  <T> void printArray(T[] arr) {
        Arrays.stream(arr).forEach((value)->System.out.println(value));
    }
}
