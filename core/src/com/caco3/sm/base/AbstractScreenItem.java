package com.caco3.sm.base;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.caco3.sm.game.PositionAware;

public abstract class AbstractScreenItem implements Renderable, Disposable, Updatable, PositionAware {
    private Texture texture;
    private float leftX;
    private float topY;

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    @Override
    public void update(float dt) {
    }

    @Override
    public void dispose() {
        texture.dispose();
    }

    @Override
    public float getLeftX() {
        return leftX;
    }

    @Override
    public float getTopY() {
        return topY;
    }

    @Override
    public float getWidth() {
        return texture.getWidth();
    }

    @Override
    public void renderInto(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, leftX, topY);
    }

    @Override
    public float getHeight() {
        return texture.getHeight();
    }

    public Texture getTexture() {
        return texture;
    }

    public void setLeftX(float leftX) {
        this.leftX = leftX;
    }

    public void setTopY(float topY) {
        this.topY = topY;
    }

    @Override
    public String toString() {
        return "AbstractScreenItem{" +
                "texture=" + texture +
                ", leftX=" + leftX +
                ", topY=" + topY +
                '}';
    }
}
