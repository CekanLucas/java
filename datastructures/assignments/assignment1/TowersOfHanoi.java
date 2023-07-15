package datastructures.assignments.assignment1;

import java.util.Arrays;

class TowersOfHanoi {
  private int[] tower1;
  private int[] tower2;
  private int[] tower3;

  TowersOfHanoi(int size) {
    this.tower1 = new int[size];
    this.tower2 = new int[size];
    this.tower3 = new int[size];

    for (int i = 0; i < tower1.length; i++) {
      tower1[i] = i + 1;
      tower2[i] = 0;
      tower3[i] = 0;
    }
  }

  public int[] getTower1() {
    return tower1;
  }

  public int[] getTower2() {
    return tower2;
  }

  public int[] getTower3() {
    return tower3;
  }

  void printTowers() {
    int length = tower1.length;

    for (int i = 0; i < length; i++) {
      System.out.print(
          printDisc(tower1[i] * 2, length - tower1[i]) + " " +
              printDisc(tower2[i] * 2, length - tower2[i]) + " " +
              printDisc(tower3[i] * 2, length - tower3[i]) + "\n");
    }
    System.out.println();
  }

  String printDisc(int disc, int padding) {
    StringBuilder discStr = new StringBuilder("");
    // padding left
    for (int i = 0; i < padding; i++) {
      discStr.append(" ");
    }
    if (disc == 0) {
      discStr.deleteCharAt(0);
      discStr.append(Ansi.RESET + "|");
    }
    // disc
    for (int i = 0; i < disc; i++) {
      discStr.append("\u2588");
    }
    // padding right
    for (int i = 0; i < padding; i++) {
      discStr.append(" ");
    }
    return ("\033[38;5;" + disc + 1 + "m" + discStr);
  }

  boolean moveDisk(int[] sourceTower, int[] destinationTower) {

    int sourceIndex = findTopDiscIndex(sourceTower);
    int destinationIndex = findTopDiscIndex(destinationTower);

    // There are no discs on source Tower
    if (sourceTower[sourceTower.length - 1] == 0) {
      return false;
    }

    // There is no space for discs on destination Tower
    if (destinationTower[0] != 0) {
      return false;
    } else if (destinationTower[destinationIndex] != 0
        && sourceTower[sourceIndex] > destinationTower[destinationIndex]) {
      // Cannot place a larger disc onto a smaller one
      return false;
    } else {
      int topIndex = destinationTower[destinationIndex] == 0 ? destinationIndex : destinationIndex - 1;
      destinationTower[topIndex] = sourceTower[sourceIndex];
      sourceTower[sourceIndex] = 0;
      return true;
    }

  }

  int findTopDiscIndex(int[] tower) {
    for (int i = 0; i < tower.length; i++) {
      if (tower[i] != 0) {
        return i;
      }
    }

    return tower.length - 1; // No discs found in this tower
  }

  public static void main(String[] args) {
    System.out.print(Ansi.CC);
    TowersOfHanoi towersOfHanoi = new TowersOfHanoi(5);
    towersOfHanoi.printTowers();
    towersOfHanoi.recursiveSolve(towersOfHanoi.getTower1().length,
        towersOfHanoi.getTower1(),
        towersOfHanoi.getTower2(),
        towersOfHanoi.getTower3());
  }

  void recursiveSolve(int n, int[] sourceTower, int[] destinationTower, int[] auxiliaryTower) {
    if (n > 0) {
      // Move discs from source tower to auxiliary tower using destination tower as
      // the temporary tower
      recursiveSolve(n - 1, sourceTower, auxiliaryTower, destinationTower);

      // Move the bottom disc from source tower to destination tower
      if (moveDisk(sourceTower, destinationTower)) {
        printTowers();

        // Move remaining discs from auxiliary tower to destination tower using source
        // tower as the temporary tower
        recursiveSolve(n - 1, auxiliaryTower, destinationTower, sourceTower);
      }
    }
  }
}

interface Ansi {
  String RESET = "\033[0m";
  String CC = "\033[2J"; // clear console
  String RED = "\033[22;31m";
  String GREEN = "\033[1;32m";
  String YELLOW = "\033[1;33m";
  String BLUE = "\033[22;34m";
  String PURPLE = "\033[1;35m";
  String WHITE = "\033[1;37m";
}

interface ColorGenerator {
  String generateRandomColor();
}

class AnsiColorGenerator implements ColorGenerator {
  @Override
  public String generateRandomColor() {
    int randomCode = (int) (Math.random() * 255);
    return "\033[1;38;5;" + randomCode + "m";
  }
}
