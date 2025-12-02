import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayOne {

    public static void main (String[] args) {
        ///Users/allenmartin/Documents/Projects/GitClones/AdventOfCode/2025/Input

        ArrayList<Integer> combination = new ArrayList<>();

        int zeroCount = 0;
        int clickCount = 0;
        int current = 50;
        Boolean negative = false;

        try {
            //store problem input from file
            File file = new File("/Users/allenmartin/Documents/Projects/GitClones/AdventOfCode/2025/Input/DayOneInput.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                char direction = line.charAt(0);
                int value = Integer.parseInt(line.substring(1));
                if (direction == 'R') {
                    combination.add(value);
                } else {
                    combination.add(value * -1);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }

        //Part One
        for (int i = 0; i < combination.size(); i++) {

            current += combination.get(i);

            if (current % 100 == 0) {
                zeroCount++;
            }

            current = current % 100;
        }

        current = 50;
        int previous;

        //Part Two
        for (int i = 0; i < combination.size(); i++) {
            previous = current;

            current += combination.get(i);

            if (current == 0 || current * previous < 0) {
                clickCount++;
            }

            clickCount += Math.abs(current / 100);

            current = current % 100;
        }

        System.out.println(zeroCount);
        System.out.println(clickCount);
    }
}
