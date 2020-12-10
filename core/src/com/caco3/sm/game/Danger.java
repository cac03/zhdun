package com.caco3.sm.game;

import com.caco3.sm.base.AbstractScreenItem;

public class Danger extends AbstractScreenItem implements Movable {
    private MoveStrategy moveStrategy;

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        moveStrategy.move(this);
    }
}
