package com.aptu.swd.sleepydruncards;


public class Field {
    private final IGameObject[][] gameObjects;

    public Field(int width, int height) {
        gameObjects = new IGameObject[width][height];
    }

    public void put(IGameObject drunkard, int x, int y) {
        Point point = findDrunkardPosition(drunkard);
        if (gameObjects[x][y] != null || point != null) {
            throw new IllegalArgumentException();
        }
        gameObjects[x][y] = drunkard;
    }

    private Point findDrunkardPosition(IGameObject gameObject) {
        for (int i = 0; i < gameObjects.length; i++) {
            for (int j = 0; j < gameObjects[i].length; j++) {
                if (gameObjects[i][j] == gameObject) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    public IGameObject get(int x, int y) {
        return gameObjects[x][y];
    }

    public void move(IMovable movable, int newX, int newY) {
        Point p = findDrunkardPosition(movable);
        if (p == null || !isMovePossible(p, new Point(newX, newY))) {
            throw new IllegalArgumentException();
        }

        gameObjects[p.x][p.y] = null;
        gameObjects[newX][newY] = movable;
    }

    private boolean isMovePossible(Point from, Point to) {
        return (gameObjects[to.x][to.y] == null || gameObjects[to.x][to.y] instanceof Column) &&
        (Math.abs(from.x - to.x) + Math.abs(from.y - to.y) <= 1);
    }
}