package com.caco3.sm.screen.gameover;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.caco3.sm.screen.SmScreen;
import com.caco3.sm.screen.menu.NewGameClickedListener;

public class GameOverScreen implements SmScreen {
  private final Texture background = new Texture("game_background.jpg");
  private final Texture zhdun = new Texture("game_over.png");
  private final BitmapFont font = new BitmapFont();
  private final int count;
  private NewGameClickedListener newGameClickedListener;
  private long createdAt = System.currentTimeMillis();

  public GameOverScreen(int count) {
    this.count = count;
    font.setColor(Color.BLACK);
  }

  @Override
  public void dispose() {
    font.dispose();
    background.dispose();
    zhdun.dispose();
  }

  @Override
  public void update(float dt) {
  }

  public void setNewGameClickedListener(NewGameClickedListener newGameClickedListener) {
    this.newGameClickedListener = newGameClickedListener;
  }

  @Override
  public void renderInto(SpriteBatch spriteBatch) {
    spriteBatch.draw(background, 0, 0);
    spriteBatch.draw(zhdun, Gdx.graphics.getWidth() / 2 - zhdun.getWidth() / 2, Gdx.graphics.getHeight() / 2- zhdun.getHeight() / 2);
    font.draw(spriteBatch, "Game over. Your score: " + count, Gdx.graphics.getWidth() / 2 - 100, 50);
    if (Gdx.input.isTouched() && System.currentTimeMillis() - createdAt > 1000) {
      newGameClickedListener.onNewGameClicked();
    }
  }
}
