package com.caco3.sm.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomDangersFactoryImpl implements DangerFactory {
    private static final List<String> DANGERS_TEXTURES_FILENAMES;

    static {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 4507; i <= 4546; i++) {
            list.add("128/" + i + ".png");
        }
        DANGERS_TEXTURES_FILENAMES = Collections.unmodifiableList(list);
    }

    private final Random random = new Random();

    @Override
    public Danger createNew() {
        int index = random.nextInt(DANGERS_TEXTURES_FILENAMES.size());

        Danger danger = new Danger();
        danger.setTexture(new Texture(DANGERS_TEXTURES_FILENAMES.get(index)));

        boolean fromTopOrBottom = random.nextBoolean();
        if (fromTopOrBottom) {
            boolean fromTop = random.nextBoolean();
            if (fromTop) {
                danger.setTopY(0);
            } else {
                danger.setTopY(Gdx.graphics.getHeight());
            }
            danger.setLeftX(Gdx.graphics.getWidth() * random.nextFloat());
        } else {
            boolean fromLeft = random.nextBoolean();
            if (fromLeft) {
                danger.setLeftX(0);
            } else {
                danger.setLeftX(Gdx.graphics.getWidth());
            }
            danger.setTopY(Gdx.graphics.getHeight() * random.nextFloat());
        }
        return danger;
    }
}
