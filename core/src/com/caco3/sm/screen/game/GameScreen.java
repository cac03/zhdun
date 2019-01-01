package com.caco3.sm.screen.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.caco3.sm.Sm;
import com.caco3.sm.game.SmGame;
import com.caco3.sm.game.SmGameImpl;
import com.caco3.sm.screen.SmScreen;

public class GameScreen implements SmScreen {
  private final Texture background = new Texture("game_background.jpg");
  private final SmGame game = new SmGameImpl(Sm.getInstance());

  @Override
  public void dispose() {
    background.dispose();
  }

  @Override
  public void update(float dt) {
    game.update(dt);
  }

  @Override
  public void renderInto(SpriteBatch spriteBatch) {
    update(Gdx.graphics.getDeltaTime());
    spriteBatch.draw(background, 0, 0);
    game.renderInto(spriteBatch);
  }
}
