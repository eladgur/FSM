package com.elad.impl;

import com.elad.framework.component.Event;
import com.elad.framework.component.State;

public class FirstState extends State {

    private Event lastEvent;

    public FirstState(String name) {
        super(name);
    }

    public void update(Event event) {
        lastEvent = event;
        if (lastEvent.getClass() == event.getClass()) {
            this.setNextState(new SecondState("B", lastEvent));
        }
    }
}