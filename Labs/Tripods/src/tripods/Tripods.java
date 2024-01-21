package tripods;

import sort.QuickSort;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * A program that finds the optimal placement of a number of tripods in an
 * N * M grid of numbers.  A tripod can touch three adjacent cells, based on orientation,
 * e.g. a north facing tripod touches the east, south and west cells.
 *
 * The goal is to find the placement of a number of tripods, such that the
 * total sums of the cells that all combined tripods touch is maximum.
 *
 * @author RIT CS
 * @author Eden Grace
 */
public class Tripods {
    /** there are 4 corners where a tripod cannot be placed in any direction */
    public final static int CORNERS = 4;
    /** when the number of cells exceeds this number it won't be displayed to standard output */
    public final static int MAX_CELLS_TO_DISPLAY = 10000;

    /**
     * Read the 2-D number grid into a 2 dimension native array. This method should
     * print the following to standard output:
     *
     * Rows: #, Columns: #
     *
     * @param filename the file with the number grid
     * @return the newly created 2-D native array of numbers
     * @throws IOException if the file cannot be found or there is an error reading
     */
    public static int[][] loadGrid(String filename) throws IOException {
        Scanner file = new Scanner(new File(filename));
        int y = file.nextInt();
        int x = file.nextInt();
        int[][] grid = new int[y][x];
        System.out.println("Rows: " + y + ", Columns: " + x);
        for (int a = 0; a < y; a++) {
            for (int b = 0; b < x; b++) {
                grid[a][b] = file.nextInt();
            }
        }
        file.close();
        return grid;
    }

    /**
     * Get the number of rows in the grid.
     *
     * @param grid the 2-D grid of numbers
     * @return number of rows
     */
    public static int getNumRows(int[][] grid) {
        return grid.length;
    }

    /**
     * Get the number of columns in the grid.
     *
     * @param grid the 2-D grid of numbers
     * @return number of columns
     */
    public static int getNumColumns(int[][] grid) {
        return grid[0].length;
    }

    /**
     * Get the maximum number of tripods that could be placed on the board.
     * A tripod cannot be placed in any of the four corners of the grid in
     * any orientation.
     *
     * @param grid the 2-D grid of numbers
     * @return the maximum number of tripods that can placed in the grid
     */
    public static int getMaxTripods(int[][] grid) {
        return grid[0].length * grid.length - 4;
    }

    /**
     * Display the grid to standard output, only if the number of cells is less
     * than or equal to MAX_CELLS_TO_DISPLAY.  If that size exceeds, print
     * "Too many cells to display" instead.  For example with tripods-3.txt:
     *
     *  0 3 7 9
     *  2 5 1 4
     *  3 3 2 1
     *  4 6 8 4
     *  4 1 2 0
     *
     * @param grid the 2-D grid of numbers
     */
    public static void displayGrid(int[][] grid) {
        if (grid.length * grid[0].length <= MAX_CELLS_TO_DISPLAY) {
            for (int i = 0; i < grid.length; i++) {
                for (int n = 0; n < grid[0].length - 1; n++) {
                    System.out.print(grid[i][n] + " ");
                }
                System.out.println(grid[i][grid[0].length -1]);
            }
        } else {
            System.out.println("Grid is too large to display");
        }
    }

    /**
     * A spot is valid if the tripod can be placed in the cell at (row, col),
     * taking into account the direction of the tripod and the location of its
     * three legs.
     *
     * @param grid the 2-D grid of numbers
     * @param row tripod's row (centered)
     * @param col tripod's column (centered)
     * @param dir the direction the tripod is facing
     * @return whether the tripod can be placed in the spot or not
     */
    public static boolean isSpotValid(int[][] grid, int row, int col, Direction dir) {
        boolean isTopEdge = row == 0;
        boolean isBottomEdge = row == grid.length - 1;
        boolean isLeftEdge = col == 0;
        boolean isRightEdge = col == grid[0].length - 1;

        if ((isTopEdge || isBottomEdge) && (isLeftEdge || isRightEdge)) {
            return false;
        }
        if (dir == Direction.SOUTH && isTopEdge) {
            return true;
        }
        if (dir == Direction.NORTH && isBottomEdge) {
            return true;
        }
        if (dir == Direction.EAST && isLeftEdge) {
            return true;
        }
        if (dir == Direction.WEST && isRightEdge) {
            return true;
        }
        return !(isTopEdge || isBottomEdge || isLeftEdge || isRightEdge);
    }

    /**
     * Given a tripod at a location in the grid and facing a certain direction,
     * sum the numbers in the grid that the three legs of the tripod stand on.
     *
     * @param grid the 2-D grid of numbers
     * @param row tripod's row (centered)
     * @param col tripod's column (centered)
     * @param dir the direction the tripod is facing
     *
     * @rit.pre spot must be valid
     *
     * @return the sum of the tripods legs
     */
    public static int getSum(int[][] grid, int row, int col, Direction dir) {
        boolean isTopEdge = row == 0;
        boolean isBottomEdge = row == grid.length - 1;
        boolean isLeftEdge = col == 0;
        boolean isRightEdge = col == grid[0].length - 1;
        boolean isEdge = isTopEdge || isBottomEdge || isLeftEdge || isRightEdge;

        switch (dir) {
            case NORTH:
                if (!isEdge || isBottomEdge) {
                    return grid[row][col - 1] + grid[row][col + 1] + grid[row - 1][col];
                }
            case SOUTH:
                if (!isEdge || isTopEdge) {
                    return grid[row][col - 1] + grid[row][col + 1] + grid[row + 1][col];
                }
            case EAST:
                if (!isEdge || isLeftEdge) {
                    return grid[row + 1][col] + grid[row - 1][col] + grid[row][col + 1];
                }
            case WEST:
                if (!isEdge || isRightEdge) {
                    return grid[row + 1][col] + grid[row - 1][col] + grid[row][col - 1];
                }
            default:
                return 0;
        }
    }

    /**
     * The main program takes the file name from the command line.  It then
     * loads the file into a 2-D native array which is then displayed.
     * Next the user is prompted for how many tripods they want for
     * the optimal sum.  If the number of tripods does not exceed the
     * total number that can be placed, the optimal tripods by location
     * are generated, then sorted by descending sum and then displayed
     * to the user.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Tripods filename");
        } else {
            try {
                int[][] grid = loadGrid(args[0]);
                // TODO
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
