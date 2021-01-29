package year2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.Utils.readLineByLineJava8;

public class Day5 {



    public static void main(String[] args) {
        List<String> lines = readLineByLineJava8(System.getProperty("user.dir") + "/input/input5.txt");

       // lines = Arrays.asList("BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL");
        int max = 0;

        for (String line : lines) {
            String part1 = line.substring(0,7);
            String part2 = line.substring(7);

            int row = getRow(part1);
            int col = getCol(part2);
            int seat = seat(row, col);
            if (seat > max) {
                max = seat;
            }

            System.out.println(row + " " + col + " " + seat);

        }

        System.out.println(max);
    }

    private static int seat(int row, int col) {
        return row * 8 + col;
    }

    private static int getCol(String string) {
        int min = 0;
        int max = 7;

        for (char c : string.toCharArray()) {
            if (c == 'L') {
                max = max - ((max-min) / 2);
            }

            if (c == 'R') {
                min = min + ((max - min) / 2);
            }
        }

        return max;
    }

    private static int getRow(String string) {
        int min = 0;
        int max = 127;

        for (char c : string.toCharArray()) {
            if (c == 'F') {
                max = max - ((max-min) / 2);
            }

            if (c == 'B') {
                min = min + ((max - min +1 ) / 2);
            }
        }

        return min;
    }

}
