package year2020;

import java.util.*;

import static utils.Utils.readLineByLineJava8;

public class Day9 {

    public static void main(String[] args) {
        List<String> lines = readLineByLineJava8(System.getProperty("user.dir") + "/input/input9.txt");
        List<Long> numbers = new ArrayList<>();

        for (String s : lines) {
            numbers.add(Long.valueOf(s));
        }

        int pointer = 0;
        int preamble = 25;

        for (int i = preamble; i < numbers.size(); i++) {
            boolean valid = false;
            for (int j = i- preamble; j < i ; j++) {
                for (int k = i - preamble; k < i; k++) {
                    if (Long.valueOf(numbers.get(j) + numbers.get(k)).equals(numbers.get(i))) {
                        valid = true;
                    }
                }
            }

            if (!valid) {
                System.out.println(numbers.get(i));
                return;
            }
        }

    }

}
