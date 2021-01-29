package year2020;

import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {

    /*
    byr (Birth Year)
    iyr (Issue Year)
    eyr (Expiration Year)
    hgt (Height)
    hcl (Hair Color)
    ecl (Eye Color)
    pid (Passport ID)
    cid (Country ID)
    */


    public static void main(String[] args) {
        List<String> lines = Utils.readLineByLineJava8(System.getProperty("user.dir") + "/input/input4.txt");
        List<String[]> passportsData = loadData(lines);

        int validCount = 0;

        passport:
        for (String[] data : passportsData) {

            /*
            byr (Birth Year) - four digits; at least 1920 and at most 2002.
            iyr (Issue Year) - four digits; at least 2010 and at most 2020.
            eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
            hgt (Height) - a number followed by either cm or in:
            If cm, the number must be at least 150 and at most 193.
            If in, the number must be at least 59 and at most 76.
            hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
            ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
            pid (Passport ID) - a nine-digit number, including leading zeroes.
            cid (Country ID) - ignored, missing or not.
            */

            if (naiveCheck(data)) continue passport;

            if (data[0].length() != 4 || Integer.valueOf(data[0]) > 2002 || Integer.valueOf(data[0]) < 1920) {
                continue passport;
            }
            if (data[1].length() != 4 || Integer.valueOf(data[1]) > 2020 || Integer.valueOf(data[1]) < 2010) {
                continue passport;
            }
            if (data[2].length() != 4 || Integer.valueOf(data[2]) > 2030 || Integer.valueOf(data[2]) < 2020) {
                continue passport;
            }

            if (data[3].endsWith("cm")) {
                String height = data[3].substring(0, data[3].length() - 2);
                try {
                    Integer integer = Integer.valueOf(height);
                    if (integer > 193 || integer < 150) {
                        continue passport;
                    }
                } catch (NumberFormatException e){
                    continue passport;
                }
            } else if (data[3].endsWith("in")) {
                String height = data[3].substring(0, data[3].length() - 2);
                try {
                    Integer integer = Integer.valueOf(height);
                    if (integer > 76 || integer < 59) {
                        continue passport;
                    }
                } catch (NumberFormatException e){
                    continue passport;
                }
            } else {
                continue passport;
            }

            String regex = "[a-f0-9]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(data[4].substring(1));

            if (!data[4].startsWith("#") || !matcher.find() || data[4].length() != 7) {
                continue passport;
            }
            if (!Arrays.asList("amb", "blue", "brn", "gry", "grn", "hzl", "oth").contains(data[5])) {
                continue passport;
            }

            String regex2 = "0.*[0-9]+";
            Pattern pattern2 = Pattern.compile(regex2);
            Matcher matcher2 = pattern2.matcher(data[6]);
            if (!matcher2.find() || data[6].length() != 9) {
                continue passport;
            }

            validCount ++;
        }

        System.out.println(validCount);
    }

    private static boolean naiveCheck(String[] data) {
        for (int i = 0; i < 7; i++) {
            if (data[i] == null) {
                return true;
            }
        }
        return false;
    }

    private static List<String[]> loadData(List<String> lines) {
        List<String[]> data = new ArrayList<>();
        int passportCounter = 0;

        for (int i = 0; i < lines.size(); i++) {
            if (data.size() <= passportCounter) {
                data.add(new String[8]);
            }

            for (String s: lines.get(i).split(" ")) {
                String[] s2  = s.split(":");
                switch (s2[0]) {
                    case "byr" :
                        data.get(passportCounter)[0] = s2[1];
                        break;
                    case "iyr" :
                        data.get(passportCounter)[1] = s2[1];
                        break;
                    case "eyr" :
                        data.get(passportCounter)[2] = s2[1];
                        break;
                    case "hgt" :
                        data.get(passportCounter)[3] = s2[1];
                        break;
                    case "hcl" :
                        data.get(passportCounter)[4] = s2[1];
                        break;
                    case "ecl" :
                        data.get(passportCounter)[5] = s2[1];
                        break;
                    case "pid" :
                        data.get(passportCounter)[6] = s2[1];
                        break;
                    case "cid" :
                        data.get(passportCounter)[7] = s2[1];
                        break;
                }
            }

            if (lines.get(i).isEmpty()) {
                passportCounter ++;
            }

        }

        return data;
    }


}
