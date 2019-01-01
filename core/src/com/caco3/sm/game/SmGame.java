package com.caco3.sm.game;

import com.badlogic.gdx.utils.Disposable;
import com.caco3.sm.base.Renderable;
import com.caco3.sm.base.Updatable;

public interface SmGame extends Renderable, Updatable, Disposable {
  boolean isOver();
  int getDangersRemovedCount();
}
