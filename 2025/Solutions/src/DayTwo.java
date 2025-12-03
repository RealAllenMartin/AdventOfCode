import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DayTwo {

    private String rawInput;

    public DayTwo() {
        try {
            List<String> placeHolder = Files.readAllLines(Path.of("/Users/allenmartin/Documents/Projects/GitClones/AdventOfCode/2025/Input/DayTwoInput.txt"));
            rawInput = placeHolder.getFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args) {
        DayTwo solution = new DayTwo();
        System.out.println("Part One: " + solution.partOne());
        System.out.println("Part Two: " + solution.partTwo());
    }

    public long partOne() {
        long sum = 0;
        String[] input = rawInput.split(",");

        for (String splitInput : input) {
            long lower = Long.parseLong(splitInput.split("-")[0]);
            long upper = Long.parseLong(splitInput.split("-")[1]);

            for (long i = lower; i <= upper; i++) {
                if (String.valueOf(i).matches("^(\\d*)\\1$")) {
                    sum += i;
                }
            }
        }
        return sum;
    }

    public long partTwo() {
        long sum = 0;
        String[] input = rawInput.split(",");

        for (String splitInput : input) {
            long lower = Long.parseLong(splitInput.split("-")[0]);
            long upper = Long.parseLong(splitInput.split("-")[1]);

            for (long i = lower; i <= upper; i++) {
                if (String.valueOf(i).matches("^(\\d*)\\1+$")) {
                    sum += i;
                }
            }
        }
        return sum;
    }

}
