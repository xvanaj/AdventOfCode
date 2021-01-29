package year2020;

import utils.Utils;

import java.util.Arrays;
import java.util.List;

public class Day3 {

    public static void main(String[] args) {
        List<String> lines = Utils.readLineByLineJava8(System.getProperty("user.dir") + "/input/input3.txt");

        String[] linesArray = new String[lines.size()];
        lines.toArray(linesArray);

        for (int i = 0; i < linesArray.length; i++) {
            for (int j = 0; j < 18; j++) {
                linesArray[i] = linesArray[i] + linesArray[i];
            }
        }

        int[] treesCount = new int[5];
        treesCount[0] = getTreesCount(linesArray, 1,1);
        treesCount[1] = getTreesCount(linesArray, 1,3);
        treesCount[2] = getTreesCount(linesArray, 1,5);
        treesCount[3] = getTreesCount(linesArray, 1,7);
        treesCount[4] = getTreesCount(linesArray, 2,1);

        long result = 1;
        for (int i = 0; i < treesCount.length; i++) {
            result = result * treesCount[i];
        }

        System.out.println(result);


        //prints forest
        /*for (int i = 0; i < linesArray.length; i++) {
            System.out.println(linesArray[i]);
        }*/
    }

    private static int getTreesCount(String[] linesArray, int linesIncrement, int columnsIncrement) {
        int linePointer = 0;
        int columnPointer = 0;
        int treesCount = 0;

        while (linePointer < linesArray.length) {
            columnPointer += columnsIncrement;
            linePointer += linesIncrement;

            if (linePointer >= linesArray.length) {
                continue;
            }

            if (linesArray[linePointer].charAt(columnPointer) == '#') {
                treesCount ++;
            }
        }
        return treesCount;
    }


}
