package com.caco3.sm.game;

public interface DangerSpawningStrategy {
  boolean needToSpawn();
  Danger spawnNew();
}
