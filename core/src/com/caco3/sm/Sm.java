package com.caco3.sm;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.caco3.sm.game.GameOverListener;
import com.caco3.sm.screen.gameover.GameOverScreen;
import com.caco3.sm.screen.ScreenManager;
import com.caco3.sm.screen.SpriteBatchTemplate;
import com.caco3.sm.screen.game.GameScreen;
import com.caco3.sm.screen.menu.MenuScreen;
import com.caco3.sm.screen.menu.NewGameClickedListener;

public class Sm extends Game implements NewGameClickedListener, GameOverListener {
  public static Sm instance = new Sm();
  private Sm() {
  }

  public static Sm getInstance() {
    return instance;
  }

  private SpriteBatchTemplate spriteBatchTemplate;
  private ScreenManager screenManager = new ScreenManager();

  @Override
  public void create() {
    spriteBatchTemplate = new SpriteBatchTemplate(new SpriteBatch());
    screenManager.push(new MenuScreen(this));
  }

  @Override
  public void render() {
    spriteBatchTemplate.render(screenManager.top());
  }

  @Override
  public void dispose() {
    spriteBatchTemplate.dispose();
  }

  @Override
  public void onNewGameClicked() {
    screenManager.push(new GameScreen());
  }

  @Override
  public void onGameOver(int count) {
    screenManager.pop().dispose();
    GameOverScreen gameOverScreen = new GameOverScreen(count);
    gameOverScreen.setNewGameClickedListener(this);
    screenManager.push(gameOverScreen);
  }
}
