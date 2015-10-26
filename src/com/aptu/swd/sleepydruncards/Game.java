package com.aptu.swd.sleepydruncards;

public class Game {
  public static void main(String[] args) {
    Field field = new Field(15, 15);
    field.put(new Drunkard(), 9, 8);
    field.put(new Column(), 5, 7);
    field.print();
  }
}
