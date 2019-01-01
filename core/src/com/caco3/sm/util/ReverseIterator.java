package com.caco3.sm.util;

import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

public class ReverseIterator<E> implements Iterator<E> {
  private final Array<E> array;
  private int index;

  public ReverseIterator(Array<E> array) {
    this.array = array;
    this.index = array.size > 0 ? array.size - 1 : 0;
  }

  @Override
  public boolean hasNext() {
    return index > 0;
  }

  @Override
  public E next() {
    return array.get(index--);
  }
}
