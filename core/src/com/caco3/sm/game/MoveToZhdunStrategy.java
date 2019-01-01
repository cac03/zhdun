package com.caco3.sm.game;

public class MoveToZhdunStrategy implements MoveStrategy {
  private static final float DISTANCE_TO_MOVE = 1f;
  private final Zhdun zhdun;

  public MoveToZhdunStrategy(Zhdun zhdun) {
    this.zhdun = zhdun;
  }

  @Override
  public void move(Moveable moveable) {
    float studentX = zhdun.getLeftX();
    float studentY = zhdun.getTopY();
    float x = moveable.getLeftX();
    float y = moveable.getTopY();

    float dx = Math.abs(studentX - x);
    float dy = Math.abs(studentY - y);

    float newX = moveable.getLeftX() + DISTANCE_TO_MOVE;
    if (dx < Math.abs(studentX - newX)) {
      newX = moveable.getLeftX() - DISTANCE_TO_MOVE;
    }

    float newY = moveable.getTopY() + DISTANCE_TO_MOVE;
    if (dy < Math.abs(studentY - newY)) {
      newY = moveable.getTopY() - DISTANCE_TO_MOVE;
    }
    moveable.setTopY(newY);
    moveable.setLeftX(newX);
  }
}
