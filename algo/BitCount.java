package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BitCount {

    public static Integer bitCount(Integer value) {
        List<Integer> digits = new ArrayList<Integer>();

        if (value == 0)
            digits.add(0);

        while (value != 0) {
            digits.add(value % 2);
            value = value / 2;
        }


        Collections.reverse(digits);
        String output = "";

        for (int i = 0 ; i <= digits.size() - 1;  i++) {
            output = output + digits.get(i).toString();
        }

        return output.length();
    }

    public static void main(String ... args) {
        System.out.println( bitCount(10));
        System.out.println( bitCount(50));
    }

}
