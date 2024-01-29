package islands;
import java.util.ArrayList;

public class Coordinates {

    private final int col;
    private final int row;

    public Coordinates(int row, int col) {
        this.col = col;
        this.row = row;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public ArrayList<Coordinates> getNeighbors() {
        ArrayList<Coordinates> Neighbors = new ArrayList<>();
        Neighbors.add(new Coordinates(this.row, this.col + 1));
        Neighbors.add(new Coordinates(this.row + 1, col));
        Neighbors.add(new Coordinates(this.row - 1, col));
        Neighbors.add(new Coordinates(this.row , col - 1));
        return Neighbors;
    }

    public boolean equals(Object other) {
        if (other instanceof Coordinates coordinates){
            return coordinates.row == this.row && coordinates.col == this.col;
        } else {
            return false;
        }
    }

    public String toString() {
        return "(" + this.row + "," + this.col + ")";
    }
}