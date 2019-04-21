package com.elad.basic;

import com.elad.framework.component.Event;
import com.elad.framework.component.State;

public class TwoEventsOccurredState extends State {

    private final Event event;

    public TwoEventsOccurredState(Event event) {
        this.event = event;
    }

    public void update(Event event) {
        if (this.event.getClass() == event.getClass()) {
            String eventType = event.getClass().getSimpleName();
            System.out.println("WARNING: Got 3 events of type: " + eventType);
            setNextState(new FinalState());
        } else {
            setNextState(new OneEventsOccurredState(event));
        }
    }
}