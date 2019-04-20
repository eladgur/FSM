package com.elad.impl;

import com.elad.framework.component.Event;
import com.elad.framework.component.State;

public class ThirdState extends State {

    private final Event event;

    public ThirdState(String name, Event event) {
        super(name);
        this.event = event;
    }

    public void update(Event event) {
        if (this.event.getClass() == event.getClass()) {
            String eventType = event.getClass().getSimpleName();
            System.out.println("WARNING: Got 3 events of type: " + eventType);
            setNextState(new ThirdState("C", event));
        } else {
            setNextState(new FirstState("A"));
        }
    }
}
