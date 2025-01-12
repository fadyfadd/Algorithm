package algo;

import java.util.HashMap;
import java.util.Map;

public class LongestStringNoRepeat {


    private static String longestStringWithNoRepeat(String input) {

        int start = 0;

        String longestString = "";
        String currentLongestString = "";

        Map<String, Integer> dic = new HashMap<>();

        while (start <= input.length() - 1) {
            var chr = input.substring(start , start + 1);
            if (!dic.containsKey(chr)) {
                currentLongestString = currentLongestString + chr;
                dic.put(chr , start);
                start += 1;
            }
            else {

                if (currentLongestString.length() > longestString.length()) {
                    longestString = currentLongestString;
                }

                start = dic.get(chr) + 1;
                currentLongestString = "";
                dic.clear();
            }
        }

        if (currentLongestString.length() > longestString.length())
            longestString = currentLongestString;

        return longestString;
    }

    public static void main(String... args) {
        String longestStringWithNoRepeat = longestStringWithNoRepeat("going to the beach");
        System.out.println(longestStringWithNoRepeat);
        System.out.print(longestStringWithNoRepeat.length());
    }
}
