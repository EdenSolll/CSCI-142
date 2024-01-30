package islands;

import java.util.ArrayList;

public class Player {

  private final PlayerRole role;

  private final ArrayList<Island> islands = null;

  private final Direction direction;

  public Player(PlayerRole role, Direction direction) {
    this.direction = direction;
    this.role = role;
  }

  public PlayerRole getRole() {
    return null;
  }

  public Direction getDirection(){
    // TODO
    return null;
  }

  public void claim(Cell cell) {
    // TODO
  }

  public boolean touchesBoardBoundaries(int rows, int cols) {
    // TODO
    return false;
  }

  public int getNumIslands(){
    // TODO
    return 0;
  }

  public ArrayList<Island> getIslands() {
    // TODO
    return null;
  }

  public void mergeIsland(Cell cell) {
    // TODO
  }

  private ArrayList<Island> getNeighborIslands(Cell cell) {
    // TODO
    return null;
  }

  @Override
  public boolean equals(Object other) {
    // TODO
    return false;
  }

  @Override
  public String toString() {
    // TODO
    return null;
  }
}