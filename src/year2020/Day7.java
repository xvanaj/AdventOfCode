package year2020;

import java.util.*;

import static utils.Utils.readLineByLineJava8;

public class Day7 {

    public static void main(String[] args) {
        List<String> lines = readLineByLineJava8(System.getProperty("user.dir") + "/input/input7.txt");
        List<List<String>> groups = getGroups(lines);

        Map<Character, Integer> counts;
        int sum = 0;
        for (List<String> group : groups) {
            sum += getAnswers(group);
        }

        System.out.println(sum);

    }

    private static int getAnswers(List<String> group) {
        Set<Character> chars = new HashSet<>();

        //initialize
        for (Character c : group.get(0).toCharArray()) {
            chars.add(c);
        }

        //remove all missing in other groups
        for (String s : group.subList(1, group.size())) {
            Set<Character> charsToRemove = new HashSet<>();

            for (Character character : chars) {
                if (!s.contains(String.valueOf(character))) {
                    charsToRemove.add(character);
                }
            }

            chars.removeAll(charsToRemove);
        }

        return chars.size();
    }

    private static List<List<String>> getGroups(List<String> lines) {
        List<List<String>> groups = new ArrayList<>();
        groups.add(new ArrayList<>());

        for (String s : lines) {
            if (s.isEmpty()) {
                groups.add(new ArrayList<>());
                continue;
            }

            groups.get(groups.size() - 1).add(s);
        }

        return groups;
    }



}
