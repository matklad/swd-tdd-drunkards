package com.aptu.swd.sleepydruncards;

public class Drunkard implements IGameObject, IMovable {
    private boolean sleeping;

    public void sleep() {
        sleeping = true;
    }

    public boolean isSleeping() {
        return true;
    }
}
