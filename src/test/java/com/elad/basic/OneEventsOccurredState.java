package com.elad.basic;

import com.elad.framework.components.Event;
import com.elad.framework.components.State;

public class OneEventsOccurredState extends State {

    private final Event event;

    public OneEventsOccurredState(Event event) {
        this.event = event;
    }

    public void update(Event event) {
        if (this.event.getClass() == event.getClass()) {
            setNextState(new TwoEventsOccurredState(event));
        } else {
            setNextState(new OneEventsOccurredState(event));
        }
    }
}
