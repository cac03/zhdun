package com.caco3.sm.game;

public class MoveToZhdunStrategy implements MoveStrategy {
    private static final float DISTANCE_TO_MOVE = 1f;
    private final Zhdun zhdun;

    public MoveToZhdunStrategy(Zhdun zhdun) {
        this.zhdun = zhdun;
    }

    @Override
    public void move(Movable movable) {
        float studentX = zhdun.getLeftX();
        float studentY = zhdun.getTopY();
        float x = movable.getLeftX();
        float y = movable.getTopY();

        float dx = Math.abs(studentX - x);
        float dy = Math.abs(studentY - y);

        float newX = movable.getLeftX() + DISTANCE_TO_MOVE;
        if (dx < Math.abs(studentX - newX)) {
            newX = movable.getLeftX() - DISTANCE_TO_MOVE;
        }

        float newY = movable.getTopY() + DISTANCE_TO_MOVE;
        if (dy < Math.abs(studentY - newY)) {
            newY = movable.getTopY() - DISTANCE_TO_MOVE;
        }
        movable.setTopY(newY);
        movable.setLeftX(newX);
    }
}
