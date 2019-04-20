package com.elad.impl;

import com.elad.framework.component.Event;
import com.elad.framework.component.State;

public class SecondState extends State {
    private final Event event;

    public SecondState(String id, Event event) {
        super(id);
        this.event = event;
    }

    public void update(Event event) {
        if (this.event.getClass() == event.getClass()) {
            setNextState(new ThirdState("C", event));
        } else {
            setNextState(new FirstState("A"));
        }
    }
}
