package com.caco3.sm.screen;

import java.util.ArrayDeque;
import java.util.Deque;

public class ScreenManager {
    private final Deque<SmScreen> screensStack = new ArrayDeque<>();

    public void push(SmScreen screen) {
        screensStack.addLast(screen);
    }

    public SmScreen pop() {
        return screensStack.removeLast();
    }

    public SmScreen top() {
        return screensStack.getLast();
    }
}
