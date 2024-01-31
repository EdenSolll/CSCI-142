package islands;

import java.util.ArrayList;

public class Player {

  private final PlayerRole role;

  private final ArrayList<Island> islands;

  private final Direction direction;

  public Player(PlayerRole role, Direction direction) {
    this.direction = direction;
    this.role = role;
    this.islands = new ArrayList<>();
  }

  public PlayerRole getRole() {
    return this.role;
  }

  public Direction getDirection(){
    return this.direction;
  }

  public void claim(Cell cell) {
    if (!cell.hasOwner()) {
      cell.claim(this.role);
      mergeIsland(cell);
    }
  }

  public boolean touchesBoardBoundaries(int rows, int cols) {
    boolean result = false;
    for (Island island: this.islands) {
      if (island.touchesBoardBoundaries(rows, cols, this.direction)) {
        result = true;
      }
    }
    return result;
  }

  public int getNumIslands(){
    return this.islands.size();
  }

  public ArrayList<Island> getIslands() {
    return this.islands;
  }

  public void mergeIsland(Cell cell) {
    Island merge_Island = new Island(cell);
    ArrayList<Island> neighbors = getNeighborIslands(cell);
    for (Island island : neighbors) {
      merge_Island.merge(island);
      this.islands.remove(island);
    }
    this.islands.add(merge_Island);
  }

  private ArrayList<Island> getNeighborIslands(Cell cell) {
    ArrayList<Island> neighborIslands = new ArrayList<>();
    ArrayList<Coordinates> neighbor_coords = cell.getCoordinates().getNeighbors();
    for (Island island : this.islands) {
      for (Coordinates coord: neighbor_coords) {
        if (island.hasCell(coord)) {
          neighborIslands.add(island);
        }
      }
    }
    return neighborIslands;
    }

  @Override
  public boolean equals(Object other) {
    return other instanceof Player player && this.role == player.role;
  }

  @Override
  public String toString() {
    return "Player: " + this.role + ", islands: " + getNumIslands();
  }
}