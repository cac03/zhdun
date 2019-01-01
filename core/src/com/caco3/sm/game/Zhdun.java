package com.caco3.sm.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.caco3.sm.base.AbstractScreenItem;

public class Zhdun extends AbstractScreenItem {

  public Zhdun() {
    Texture texture = new Texture("zhdun.png");
    setTexture(texture);
    setLeftX(Gdx.graphics.getWidth() / 2 - texture.getWidth() / 2);
    setTopY(Gdx.graphics.getHeight() / 2 - texture.getHeight() / 2);
  }
}
