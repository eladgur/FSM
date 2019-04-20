package com.elad.impl;

import com.elad.framework.component.Event;

public class InputEvent extends Event {
    private final String input;

    public InputEvent(String id, String input) {
        super(id);
        this.input = input;
    }
}
