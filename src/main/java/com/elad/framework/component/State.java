package com.elad.framework.component;

import com.elad.framework.interfaces.StateContext;
import com.elad.framework.interfaces.Observer;

public abstract class State implements Observer {

    private StateContext context;

    protected void setNextState(State state) {
        System.out.println("Changing state to: " + state);
        context.changeState(state);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public void setContext(StateContext context) {
        this.context = context;
    }
}