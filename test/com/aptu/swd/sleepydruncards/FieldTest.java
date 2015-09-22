package com.aptu.swd.sleepydruncards;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class FieldTest {

    private Field field;

    @Before
    public void setUp() throws Exception {
        field = new Field(15, 15);
    }

    @Test
    public void testField() throws Exception {
        Drunkard drunkard = new Drunkard();
        field.put(drunkard, 2, 2);
        IGameObject someone = field.get(2, 2);
        assertTrue(someone == drunkard);
    }

    @Test
    public void testNull() throws Exception {
        assertNull(field.get(0, 0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRange() {
        field.get(-1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDoublePut() throws Exception {
        field.put(new Drunkard(), 1, 1);
        field.put(new Drunkard(), 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutTheSameDrunkard() {
        Drunkard drunkard = new Drunkard();
        field.put(drunkard, 0, 0);
        field.put(drunkard, 0, 1);
    }

    @Test
    public void testMoveDrunkard() throws Exception {
        Drunkard d = new Drunkard();
        field.put(d, 2, 2);
        field.move(d, 1, 2);
        assertNull(field.get(2, 2));

        assertTrue(field.get(1, 2) == d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotVeryFast() throws Exception {
        Drunkard d = new Drunkard();
        field.put(d, 2, 2);
        field.move(d, 10, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCanMoveOnlyInFieldDrunkard() throws Exception {
        Drunkard drunkard = new Drunkard();
        field.move(drunkard, 0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDrunkardCantMoveToOccupiedPoint() throws Exception {
        field.put(new Drunkard(),0,0);
        Drunkard drunkard = new Drunkard();
        field.put(drunkard,1,0);
        field.move(drunkard,0,0);
    }

    @Test
    public void canPlaceColumn() {
        field.put(new Column(), 0,0);
    }

    @Test
    public void canMoveDrunkardToColumn() {
        field.put(new Column(), 0, 5);
        Drunkard drunkard = new Drunkard();
        field.put(drunkard, 0, 4);
        field.move(drunkard, 0, 5);
        assertTrue(drunkard.isSleeping());
    }
}