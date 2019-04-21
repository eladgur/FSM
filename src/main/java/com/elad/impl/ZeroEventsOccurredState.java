package com.elad.impl;

import com.elad.framework.component.Event;
import com.elad.framework.component.State;

public class ZeroEventsOccurredState extends State {

    public void update(Event event) {
        setNextState(new OneEventsOccurredState(event));
    }
}