package com.aptu.swd.sleepydruncards;

public class Drunkard implements Figure {
  private boolean sleeping;

  public void sleep() {
    sleeping = true;
  }

  public boolean isSleeping() {
    return sleeping;
  }

  @Override
  public char getAvatar() {
    return isSleeping() ? '/' : '&';
  }

  @Override
  public void move(final Point from, final Point to, final Field field) {
    if (!(Math.abs(from.x - to.x) + Math.abs(from.y - to.y) <= 1)) {
      throw new IllegalArgumentException("not so fast");
    }

    Figure obstacle = field.at(to);

    if (obstacle instanceof Column) {
      sleep();
      return;
    }

    if (obstacle != null) {
      throw new IllegalArgumentException("occupied");
    }

    field.moveObject(from, to);
  }
}
