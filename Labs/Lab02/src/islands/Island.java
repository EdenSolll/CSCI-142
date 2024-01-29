package islands;

import java.util.ArrayList;

public class Island {

   private final ArrayList<Cell> cells;

   public Island() {
       this.cells = new ArrayList<>();
   }

   public Island(Cell cell) {
       this.cells = new ArrayList<>();
       this.cells.add(cell);
   }

   public void merge(Island island) {
       for (Cell cell : island.cells) {
           addCell(cell);
       }
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
       return false;
   }

   @Override
   public boolean equals(Object other) {
       if (other instanceof Island island) {
           return this.cells.containsAll(island.cells) && island.cells.containsAll(this.cells);
       } else {
           return false;
       }
   }

   @Override
   public String toString() {
       for (Cell cell : this.cells) {
           return ("(" + cell.getRow() + "," + cell.getCol() + ")");
       }
       return null;
   }

 }