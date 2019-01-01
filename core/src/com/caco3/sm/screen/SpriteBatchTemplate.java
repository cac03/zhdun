package com.caco3.sm.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.caco3.sm.base.Renderable;

public class SpriteBatchTemplate implements Disposable {
  private final SpriteBatch spriteBatch;

  public SpriteBatchTemplate(SpriteBatch spriteBatch) {
    this.spriteBatch = spriteBatch;
  }

  public void render(Renderable renderable) {
    spriteBatch.begin();
    renderable.renderInto(spriteBatch);
    spriteBatch.end();
  }

  @Override
  public void dispose() {
    spriteBatch.dispose();
  }
}
