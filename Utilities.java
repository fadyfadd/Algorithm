
import java.util.Arrays;

public class Utilities {
    public static  <T> void printArray(T[] arr) {
        Arrays.stream(arr).forEach((value)->System.out.println(value));
    }
}
