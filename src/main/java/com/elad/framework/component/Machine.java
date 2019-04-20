package com.elad.framework.component;

import com.elad.framework.interfaces.IStateContext;
import com.elad.framework.interfaces.Observer;

public class Machine implements Observer, IStateContext {

    private State state;

    public Machine(State initialState) {
        state = initialState;
        state.setContext(this);
    }

    public void changeState(State newState) {
        this.state = newState;
    }

    public void update(Event event) {
        state.update(event);
    }
}