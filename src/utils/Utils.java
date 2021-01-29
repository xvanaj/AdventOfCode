package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    public static List<String> readLineByLineJava8(String filePath) {
        List<String> contents = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            contents = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contents;
    }

}
