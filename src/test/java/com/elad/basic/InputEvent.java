package com.elad.basic;

import com.elad.framework.components.Event;

public class InputEvent extends Event {
    private final String input;

    public InputEvent(String id, String input) {
        super(id);
        this.input = input;
    }
}
