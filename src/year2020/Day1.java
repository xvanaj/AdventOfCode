package year2020;

import java.util.ArrayList;
import java.util.List;

import static utils.Utils.readLineByLineJava8;

public class Day1 {

    public static void main(String[] args) {
        List<String> strings = readLineByLineJava8(System.getProperty("user.dir") + "/input/input.txt");
        List<Integer> integers = new ArrayList<>();
        for (String s : strings) {
            integers.add(Integer.valueOf(s));
        }

        for (int i = 0; i < integers.size(); i++) {
            for (int j = 0; j < integers.size(); j++) {
                if (Integer.valueOf(integers.get(i) + integers.get(j)).equals(2020)) {
                    System.out.println(integers.get(i) * integers.get(j));
                    return;
                }
            }
        }
    }

}
