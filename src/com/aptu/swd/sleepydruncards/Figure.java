package com.aptu.swd.sleepydruncards;

public interface Figure {
  char getAvatar();

  default void move(Point from, Point to, Field field) {

  }
}
