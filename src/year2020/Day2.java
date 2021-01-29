package year2020;

import utils.Utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day2 {

    private static int validPasswords;

    public static void main(String[] args) {
        List<String> strings = Utils.readLineByLineJava8(System.getProperty("user.dir") + "/input/input2.txt");

        //partOne(strings);
        partTwo(strings);

        System.out.println(validPasswords);

    }

    private static void partTwo(List<String> strings) {
        for (String s : strings) {
            String[] parsed = s.split(" ");
            String[] countsParsed = parsed[0].split("-");
            int minCount = Integer.parseInt(countsParsed[0]);
            int maxCount = Integer.parseInt(countsParsed[1]);

            char requiredChar = parsed[1].charAt(0);
            String password = parsed[2];

            if (password.charAt(minCount - 1) == requiredChar && password.charAt(maxCount - 1) != requiredChar) {
                validPasswords ++;
            }
            if (password.charAt(minCount - 1) != requiredChar && password.charAt(maxCount - 1) == requiredChar) {
                validPasswords ++;
            }
        }
    }

    private static void partOne(List<String> strings) {
        for (String s : strings) {
            String[] parsed = s.split(" ");
            String[] countsParsed = parsed[0].split("-");
            int minCount = Integer.parseInt(countsParsed[0]);
            int maxCount = Integer.parseInt(countsParsed[1]);
            int actualCount = 0;
            char requiredChar = parsed[1].charAt(0);
            String password = parsed[2];

            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) == requiredChar) {
                    actualCount ++;
                }
            }

            if (actualCount >= minCount && actualCount <= maxCount) {
                validPasswords ++;
            }
        }
    }

}
