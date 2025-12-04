import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class DayThree {

    private List<String> rawInput;

    public DayThree() {
        try {
            rawInput = Files.readAllLines(Path.of("/Users/allenmartin/Documents/Projects/GitClones/AdventOfCode/2025/Input/DayThreeInput.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args) {
        DayThree solution = new DayThree();
        System.out.println(solution.partOne());
        System.out.println(solution.partTwo());
    }

    public int partOne() {
        int sum = 0;

        for (String row : rawInput) {
            String voltage = row.substring(0, 2);

            for (int i = 1; i < row.length(); i++) {
                int tens = Integer.parseInt(voltage.substring(0, 1));
                int ones = Integer.parseInt(voltage.substring(1, 2));
                int current = Integer.parseInt(row.substring(i, i + 1));
                if (current > tens && i < row.length() - 1) {
                    voltage = row.substring(i, i + 1) + row.substring(i + 1, i + 2);
                } else if (current > ones) {
                    voltage = voltage.substring(0, 1) + row.substring(i, i + 1);
                }
            }
            sum += Integer.parseInt(voltage);
        }

        return sum;
    }

    public long partTwo() {
        long sum = 0;

        for (String row : rawInput) {
            Stack<Integer> batteries = new Stack<>();

            batteries.push(Integer.parseInt(row.substring(0,1)));

            for (int i = 1; i < row.length(); i++) {
                int current = Integer.parseInt(row.substring(i, i + 1));
                if (row.length() - i == 12 - batteries.size()) {
                    batteries.push(current);
                } else {
                    while (current > batteries.peek() && 12 - batteries.size() < row.length() - i) {
                        batteries.pop();
                        if (batteries.empty()) {
                            break;
                        }
                    }
                    if (batteries.size() < 12) {
                        batteries.push(current);
                    }
                }
            }
            long result = 0;
            for (int i = 0; i < 12; i++) {
                result += (long) batteries.pop() * (long) Math.pow(10, i);
            }
            sum += result;

        }

        return sum;
    }
}
