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
}
