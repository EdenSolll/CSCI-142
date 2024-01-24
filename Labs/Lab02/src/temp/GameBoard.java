package islands;

public class GameBoard {

    // TODO YOUR CODE HERE

    /**
     * Return a string representation of the board, e.g. a 3x3 board:
     * <br><pre>
     *       0  1  2
     *     _________
     *  0 |  *     -
     *  1 |     -  *
     *  2 |  -  *
     *
     * Player: RED, islands: #, Player: BLUE, islands: #
     * Moves: #, Turn: {Player}
     * </pre>
     *
     * If the game is over, it will print who is the winner or whether it is a tie, e.g:
     *<br><pre>
     *      0  1  2
     *     _________
     *  0 |  *  *  *
     *  1 |  -  -  -
     *  2 |  -  *
     *
     * Player: RED, islands: #, Player: BLUE, islands: #
     *
     * {Player} wins # to #!
     * </pre>
     *
     * @return the string representation of the game's status
     * @see Player#toString()
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(" ");
        result.append(System.lineSeparator());
        // first display the game board
        result.append("    ");
        for (int col = 0; col < this.columns; col++) {
            result.append(String.format("%3d", col));
        }
        result.append(System.lineSeparator());
        result.append("    ");
        for (int col = 0; col < this.columns; col++) {
            result.append("___");
        }
        result.append(System.lineSeparator());

        // rows of indices and then cell values
        for (int row = 0; row < this.rows; row++) {
            result.append(String.format("%2d |", row));

            // cell values
            for (int column = 0; column < this.columns; column++) {
                String sep = "  ";
                result.append(sep);
                result.append(this.board[row][column].getOwner().getLabel());
            }
            result.append(System.lineSeparator());
        }
        // players status
        result.append(System.lineSeparator());
        result.append(this.redPlayer);
        result.append(", ");
        result.append(this.bluePlayer);
        result.append(System.lineSeparator());

        // next display the game status
        if (!gameOver()) {
            result.append("Moves: ");
            result.append(this.moves);
            result.append(", ");
            result.append("Turn: ");
            result.append(this.currentPlayer.getRole());
        } else {
            if (this.redPlayer.getNumIslands() > this.bluePlayer.getNumIslands()) {
                result.append("\nRED wins ");
                result.append(this.redPlayer.getNumIslands());
                result.append(" to ");
                result.append(this.bluePlayer.getNumIslands());
                result.append("!");
            } else if (this.bluePlayer.getNumIslands() > this.redPlayer.getNumIslands()) {
                result.append("\nBLUE wins ");
                result.append(this.bluePlayer.getNumIslands());
                result.append(" to ");
                result.append(this.redPlayer.getNumIslands());
                result.append("!");
            } else {
                result.append("\nTIE game ");
                result.append(this.redPlayer.getNumIslands());
                result.append(" to ");
                result.append(this.bluePlayer.getNumIslands());
                result.append("!");
            }
        }
        return result.toString();
    }
}
