package com.elad.framework.component;

import com.elad.framework.interfaces.IStateContext;
import com.elad.framework.interfaces.Observer;

public abstract class State implements Observer {

    private String name;
    private IStateContext context;

    public State(String name) {
        this.name = name;
    }

    protected void setNextState(State state) {
        System.out.println("Changing state to: {0}" + state);
        context.changeState(state);
    }

    @Override
    public String toString() {
        return "state" + this.name;
    }

    public void setContext(IStateContext context) {
        this.context = context;
    }
}