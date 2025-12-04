import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayFour {

    private List<String> rawInput;

    public DayFour() {
        try {
            rawInput = Files.readAllLines(Path.of("/Users/allenmartin/Documents/Projects/GitClones/AdventOfCode/2025/Input/DayFourInput.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args) {
        DayFour solution = new DayFour();
        System.out.println(solution.partOne());
        System.out.println(solution.partTwo());
    }

    public int partOne() {
        int sum = 0;
        List<List<String>> board = refineInput();
        int width = board.getFirst().size();
        int height = board.size();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int pallets = 0;

                //Check top left
                if (row - 1 >= 0 && col - 1 >= 0) {
                    pallets += (isPallet(board.get(row - 1).get(col - 1))) ? 1 : 0;
                }
                //Check top
                if (row - 1 >= 0) {
                    pallets += (isPallet(board.get(row - 1).get(col))) ? 1 : 0;
                }
                //Check top right
                if (row - 1 >= 0 && col + 1 < width) {
                    pallets += (isPallet(board.get(row - 1).get(col + 1))) ? 1 : 0;
                }
                //Check right
                if (col + 1 < width) {
                    pallets += (isPallet(board.get(row).get(col + 1))) ? 1 : 0;
                }
                //Check bottom right
                if (row + 1 < height && col + 1 < width) {
                    pallets += (isPallet(board.get(row + 1).get(col + 1))) ? 1 : 0;
                }
                //Check bottom
                if (row + 1 < height) {
                    pallets += (isPallet(board.get(row + 1).get(col))) ? 1 : 0;
                }
                //Check bottom left
                if (row + 1 < height && col - 1 >= 0) {
                    pallets += (isPallet(board.get(row + 1).get(col - 1))) ? 1 : 0;
                }
                //Check left
                if (col - 1 >= 0) {
                    pallets += (isPallet(board.get(row).get(col - 1))) ? 1 : 0;
                }

                sum += (pallets < 4 && isPallet(board.get(row).get(col))) ? 1 : 0;
            }

        }

        return sum;
    }

    public int partTwo() {
        int sum = 0;
        List<List<String>> board = refineInput();
        int width = board.getFirst().size();
        int height = board.size();

        boolean removedPallet = true;
        while (removedPallet) {
            int prevSum = sum;
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    int pallets = 0;

                    //Check top left
                    if (row - 1 >= 0 && col - 1 >= 0) {
                        pallets += (isPallet(board.get(row - 1).get(col - 1))) ? 1 : 0;
                    }
                    //Check top
                    if (row - 1 >= 0) {
                        pallets += (isPallet(board.get(row - 1).get(col))) ? 1 : 0;
                    }
                    //Check top right
                    if (row - 1 >= 0 && col + 1 < width) {
                        pallets += (isPallet(board.get(row - 1).get(col + 1))) ? 1 : 0;
                    }
                    //Check right
                    if (col + 1 < width) {
                        pallets += (isPallet(board.get(row).get(col + 1))) ? 1 : 0;
                    }
                    //Check bottom right
                    if (row + 1 < height && col + 1 < width) {
                        pallets += (isPallet(board.get(row + 1).get(col + 1))) ? 1 : 0;
                    }
                    //Check bottom
                    if (row + 1 < height) {
                        pallets += (isPallet(board.get(row + 1).get(col))) ? 1 : 0;
                    }
                    //Check bottom left
                    if (row + 1 < height && col - 1 >= 0) {
                        pallets += (isPallet(board.get(row + 1).get(col - 1))) ? 1 : 0;
                    }
                    //Check left
                    if (col - 1 >= 0) {
                        pallets += (isPallet(board.get(row).get(col - 1))) ? 1 : 0;
                    }

                    if (pallets < 4 && isPallet(board.get(row).get(col))) {
                        sum++;
                        board.get(row).set(col, ".");
                    }

                    removedPallet = sum > prevSum;
                }

            }
        }

        return sum;
    }

    public List<List<String>> refineInput() {
        List<List<String>> board = new ArrayList<>();
        for (String row : rawInput) {
            board.add(Arrays.asList(row.split("")));
        }
        return board;
    }

    public boolean isPallet(String symbol) {
        return (symbol.equals("@"));
    }

}
