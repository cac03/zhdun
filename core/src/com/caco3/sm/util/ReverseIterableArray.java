package com.caco3.sm.util;

import com.badlogic.gdx.utils.Array;

public class ReverseIterableArray<E> extends Array<E> {
    @Override
    public ArrayIterator<E> iterator() {
        return new ReverseIterator<>(this);
    }
}
