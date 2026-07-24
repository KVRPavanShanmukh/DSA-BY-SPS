
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Streams_API_Learning {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 22);


        //wanting to get only even numbers from a list!
        List<Integer> ls1 = ls.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        for (int i : ls1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
