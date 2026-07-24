
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencySort {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Character> sortedChars = frequencyMap.keySet().stream()
                .sorted((a, b) -> frequencyMap.get(b).compareTo(frequencyMap.get(a)))
                .collect(Collectors.toList());

        System.out.println("Characters sorted by frequency: " + sortedChars);
        s.close();
    }
}



/*

Breakdown of Stream Methods Used:
chars(): Converts the string into an IntStream of character codes.
mapToObj(): An intermediate operation that transforms the primitive integers back into Character objects
collect(): A terminal operation that triggers the pipeline to produce a result, such as a Map or a List
groupingBy and counting: These utility methods act like the frequency counters discussed in the sources, storing how many times each character appears
sorted(Comparator): As we discussed regarding Custom Sorting, this method takes a lambda expression to compare two characters based on their associated values in the frequency map [193, Previous Conversation].

Complexity Analysis
Time Complexity: The frequency counting takes O(n) time
Sorting the unique characters (k) takes O(klogk)

Total complexity is generally dominated by the initial scan of the string, making it very efficient for standard text processing.

Space Complexity: Uses O(k) space to store the frequency map, where k is the number of distinct characters
*/