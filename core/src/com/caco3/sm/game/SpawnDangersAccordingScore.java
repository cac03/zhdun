package com.caco3.sm.game;

public class SpawnDangersAccordingScore implements DangerSpawningStrategy {
    private final SmGame smGame;
    private long lastSpawnedTimeMillis;
    private final MoveStrategy moveStrategy;
    private final DangerFactory dangerFactory = new RandomDangersFactoryImpl();

    public SpawnDangersAccordingScore(SmGame smGame, MoveStrategy moveStrategy) {
        this.smGame = smGame;
        this.moveStrategy = moveStrategy;
    }

    @Override
    public boolean needToSpawn() {
        long now = System.currentTimeMillis();
        long diff = now - lastSpawnedTimeMillis;
        int count = smGame.getDangersRemovedCount();
        if (count < 10) {
            return diff > 800;
        } else if (count < 30) {
            return diff > 600;
        } else if (count < 50) {
            return diff > 400;
        } else if (count < 100) {
            return diff > 300;
        } else {
            return diff > 250;
        }

    }

    @Override
    public Danger spawnNew() {
        lastSpawnedTimeMillis = System.currentTimeMillis();
        Danger danger = dangerFactory.createNew();
        danger.setMoveStrategy(moveStrategy);
        return danger;
    }
}
