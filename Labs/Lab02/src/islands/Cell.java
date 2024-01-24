package islands;

/**
 * Represents a single cell in the game Islands. A cell is uniquely
 * identified by its row and column coordinates.
 *
 * @author RIT CS
 * @author YOUR NAME HERE
 */
public class Cell {

    /**
     * Create the cell with the given integer values as row and column.
     * By default, the cell has no owner (islands.PlayerRole.None).
     *
     * @param row the row value
     * @param col the column
     */
    public Cell(int row, int col) {
        // TODO
    }

    /**
     * Claim the cell. A cell should be claimed by a player
     * only if the cell has no owner. This method should be called
     * exactly once.
     *
     * @param player the owner that has claimed the cell
     */
    public void claim(PlayerRole player) {
        // TODO
    }

    /**
     * Does the cell have an owner?
     *
     * @return whether the cell has an owner
     */
    public boolean hasOwner() {
        // TODO
        return false;
    }

    /**
     * Get the row.
     *
     * @return the row
     */
    public int getRow() {
        // TODO
        return 0;
    }

    /**
     * Get the column.
     *
     * @return the column
     */
    public int getCol() {
        // TODO
        return 0;
    }

    /**
     * Get the coordinates of this cell.
     *
     * @return the cell's location
     */
    public Coordinates getCoordinates() {
        // TODO
        return null;
    }

    /**
     * Get the owner of the cell.
     *
     * @return the owner, islands.PlayerRole.NONE if not owned
     */
    public PlayerRole getOwner() {
        // TODO
        return null;
    }

    /**
     * Two cells are equals if they have the same row and column.
     *
     * @param other the cell to compare with
     * @return whether they are equals or not
     */
    @Override
    public boolean equals(Object other) {
        // TODO
        return false;
    }

    /**
     * Returns the cell's owner followed by the coordinates, e.g.:
     * <pre>
     * RED: (0,0)
     * </pre>
     *
     * @return the cell's owner followed by the cell's coordinates.
     * @see PlayerRole
     * @see Coordinates#toString()
     */
    @Override
    public String toString() {
        // TODO
        return null;
    }
}
