package com.elad.basic;

import com.elad.framework.components.Event;
import com.elad.framework.components.State;

public class ZeroEventsOccurredState extends State {

    public void update(Event event) {
        setNextState(new OneEventsOccurredState(event));
    }
}