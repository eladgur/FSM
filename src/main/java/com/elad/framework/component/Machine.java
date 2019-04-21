package com.elad.framework.component;

import com.elad.framework.interfaces.StateContext;
import com.elad.framework.interfaces.Observer;

public class Machine implements Observer, StateContext {

    private State state;

    public Machine(State initialState) {
        initialState.setContext(this);
        state = initialState;
    }

    public void changeState(State newState) {
        newState.setContext(this);
        this.state = newState;
    }

    public void update(Event event) {
        state.update(event);
    }

    public State getState() {
        return state;
    }
}