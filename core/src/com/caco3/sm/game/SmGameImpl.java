package com.caco3.sm.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.caco3.sm.util.ReverseIterableArray;

public class SmGameImpl implements SmGame {
    private final Zhdun zhdun = new Zhdun();
    private final Array<Danger> dangers = new ReverseIterableArray<>();
    private final MoveStrategy moveStrategy = new MoveToZhdunStrategy(zhdun);
    private final SpawnDangersAccordingScore spawnDangersAccordingScore
            = new SpawnDangersAccordingScore(this, moveStrategy);
    private int dangersRemoved = 0;
    private final GameOverListener gameOverListener;
    private final BitmapFont bitmapFont = new BitmapFont();
    private boolean over = false;

    public SmGameImpl(GameOverListener gameOverListener) {
        dangers.add(spawnDangersAccordingScore.spawnNew());
        this.gameOverListener = gameOverListener;
        bitmapFont.setColor(Color.BLACK);
    }

    @Override
    public void dispose() {
        zhdun.dispose();
        for (Danger danger : dangers) {
            danger.dispose();
        }
    }

    @Override
    public void update(float dt) {
        while (spawnDangersAccordingScore.needToSpawn()) {
            dangers.add(spawnDangersAccordingScore.spawnNew());
        }
        zhdun.update(dt);
        for (Danger danger : dangers) {
            danger.update(dt);
        }

        if (isGameOver()) {
            over = true;
            gameOverListener.onGameOver(dangersRemoved);
        }

        if (Gdx.input.justTouched()) {
            float touchX = Gdx.input.getX();
            float touchY = Gdx.input.getY();
            Rectangle rectangle = new Rectangle();

            for (Danger danger : dangers) {
                rectangle.setX(danger.getLeftX());
                rectangle.setY(Gdx.graphics.getHeight() - danger.getTopY() - danger.getTexture().getHeight());
                rectangle.setWidth(danger.getWidth());
                rectangle.setHeight(danger.getHeight());
                if (rectangle.contains(touchX, touchY)) {
                    dangersRemoved++;
                    dangers.removeValue(danger, true);
                    break;
                }
            }
        }

    }

    private boolean isGameOver() {
        Rectangle studentRectangle = new Rectangle();
        studentRectangle.setX(zhdun.getLeftX());
        studentRectangle.setY(Gdx.graphics.getHeight() - zhdun.getTopY() - zhdun.getTexture().getHeight());
        studentRectangle.setWidth(zhdun.getWidth());
        studentRectangle.setHeight(zhdun.getHeight());
        Rectangle rectangle = new Rectangle();
        for (Danger danger : dangers) {
            rectangle.setX(danger.getLeftX());
            rectangle.setY(Gdx.graphics.getHeight() - danger.getTopY() - danger.getTexture().getHeight());
            rectangle.setWidth(danger.getWidth());
            rectangle.setHeight(danger.getHeight());
            if (rectangle.overlaps(studentRectangle)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void renderInto(SpriteBatch spriteBatch) {
        zhdun.renderInto(spriteBatch);
        for (Danger danger : dangers) {
            danger.renderInto(spriteBatch);
        }
        bitmapFont.draw(spriteBatch, "Score: " + dangersRemoved, 50, 100);
    }

    @Override
    public boolean isOver() {
        return over;
    }

    @Override
    public int getDangersRemovedCount() {
        return dangersRemoved;
    }
}
