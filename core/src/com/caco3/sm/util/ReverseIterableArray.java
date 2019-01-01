package com.caco3.sm.util;

import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

public class ReverseIterableArray<E> extends Array<E> {
  @Override
  public Iterator<E> iterator() {
    return new ReverseIterator<>(this);
  }
}
