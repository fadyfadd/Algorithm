package algo;

import java.util.*;

public class StringsWithNoRepeat {

    private static List<String> stringsWithNoRepeat(String input) {

        int start = 0;
        String currentLongestString = "";
        List<String> output = new ArrayList<String>();

        Map<String, Integer> dic = new HashMap<>();

        while (start <= input.length() - 1) {
            var chr = input.substring(start , start + 1);
            if (!dic.containsKey(chr)) {
                currentLongestString = currentLongestString + chr;
                dic.put(chr , start);
                start += 1;
            }
            else {
                output.add(currentLongestString);
                start = dic.get(chr) + 1;
                currentLongestString = "";
                dic.clear();
            }
        }

        output.add(currentLongestString);

        return output;
    }
    private static void formatAndPrint(List<String> values , String initialString) {
        System.out.println("_____________________________________________");
        System.out.println("<" + initialString + ">");
        values.stream().forEach((a)->{System.out.println(a);});
        var longest = values.stream().reduce((aggregate , currentItem)->{
            if (currentItem.length() > aggregate.length())
                return currentItem;
            return aggregate;
        });

        System.out.println("-");
        System.out.println(longest.get());
        System.out.println(longest.get().length());
        System.out.println("_____________________________________________");
    }
    public static void main(String... args) {

        formatAndPrint(stringsWithNoRepeat("going to the beach") , "going to the beach");
        formatAndPrint(stringsWithNoRepeat("") , "");

    }
}
