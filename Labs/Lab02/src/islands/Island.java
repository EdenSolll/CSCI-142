package islands;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Island {

   private final ArrayList<Cell> cells;

   public Island() {
       this.cells = new ArrayList<>();
   }

   public Island(Cell cell) {
       this.cells = new ArrayList<>(Arrays.asList(cell));
   }

   public void merge(Island island) {
       for (Cell cell : island.cells) addCell(cell);
   }

   public int size() {
       return this.cells.size();
   }

   public boolean hasCell(Coordinates coordinates) {
       return cells.contains(new Cell(coordinates.getRow(), coordinates.getCol()));
   }
   public void addCell(Cell cell) {
       this.cells.add(cell);
   }

   public boolean touchesBoardBoundaries(int rows, int cols, Direction direction) {
       ArrayList<Integer> occupied_rows = new ArrayList<>();
       ArrayList<Integer> occupied_cols = new ArrayList<>();
       for (Cell cell : cells) {
           occupied_rows.add(cell.getRow());
           occupied_cols.add(cell.getCol());
       }
       if (direction == Direction.VERTICAL) {
           return (occupied_rows.contains(0) && occupied_rows.contains(rows - 1));
       } else if (direction == Direction.HORIZONTAL) {
           return (occupied_cols.contains(0) && occupied_cols.contains(cols - 1));
       } else {
           return false;
       }
   }

   @Override
   public boolean equals(Object other) {
       return other instanceof Island island && this.cells.containsAll(island.cells) && island.cells.containsAll(this.cells);
   }

   @Override
   public String toString() {
       return "Island{size:" + size() + "}" + (cells.isEmpty() ? "": "\n\t") + this.cells.stream().map(cell -> "(" + cell.getRow() + "," + cell.getCol() + ")").collect(Collectors.joining());
   }
 }