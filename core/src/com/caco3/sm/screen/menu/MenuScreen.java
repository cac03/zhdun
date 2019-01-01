package com.caco3.sm.screen.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.caco3.sm.screen.SmScreen;

public class MenuScreen implements SmScreen {
  private final Texture background = new Texture("game_background.jpg");
  private final NewGameClickedListener listener;
  private final Texture welcome = new Texture("welcome.png");

  public MenuScreen(NewGameClickedListener listener) {
    this.listener = listener;
  }

  @Override
  public void renderInto(SpriteBatch spriteBatch) {
    spriteBatch.draw(background, 0, 0);
    spriteBatch.draw(welcome, Gdx.graphics.getWidth() / 2 - welcome.getWidth() / 2,
        Gdx.graphics.getHeight() / 2 - welcome.getHeight() / 2);
    if (Gdx.input.isTouched()) {
      listener.onNewGameClicked();
    }
  }

  @Override
  public void dispose() {
    background.dispose();
    welcome.dispose();
  }

  @Override
  public void update(float dt) {
  }
}
