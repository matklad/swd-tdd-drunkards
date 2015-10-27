package com.aptu.swd.sleepydruncards;


import java.util.Arrays;

import static java.util.stream.Collectors.reducing;

public class Field {
  private final Figure[][] figures;

  public Field(int width, int height) {
    figures = new Figure[width][height];
  }

  public void put(Figure figure, int x, int y) {
    Point point = findDrunkardPosition(figure);
    if (figures[x][y] != null || point != null) {
      throw new IllegalArgumentException();
    }
    figures[x][y] = figure;
  }

  private Point findDrunkardPosition(Figure figure) {
    for (int i = 0; i < figures.length; i++) {
      for (int j = 0; j < figures[i].length; j++) {
        if (figures[i][j] == figure) {
          return new Point(i, j);
        }
      }
    }
    return null;
  }

  public Figure get(int x, int y) {
    return figures[x][y];
  }

  public void move(Figure figure, int newX, int newY) {
    Point from = findDrunkardPosition(figure);
    Point to = new Point(newX, newY);
    if (from == null) {
      throw new IllegalArgumentException();
    }

    figure.move(from, to, this);
  }

  void moveObject(Point from, Point to) {
    Figure f = at(from);
    figures[from.x][from.y] = null;
    figures[to.x][to.y] = f;
  }

  Figure at(Point p) {
    return figures[p.x][p.y];
  }

  public void print() {
    for (Figure[] figure : figures) {
      String s = Arrays.stream(figure).map(f -> (f != null) ? f.getAvatar() : '.')
          .collect(reducing("", String::valueOf, (s1, s2) -> s1 + s2));
      System.out.println(s);
    }
  }
}