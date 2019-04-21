package com.elad.framework.components;

import com.elad.framework.interfaces.StateContext;
import com.elad.framework.interfaces.Observer;

import java.io.*;

public class Machine implements Observer, StateContext, Serializable {

    private static final String STATE_FILE_NAME = "state.ser";
    private State state;

    public Machine() {
        loadState();
    }

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

    public void saveState() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(STATE_FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(state);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("Machine: Fail to save state");
            e.printStackTrace();
        }
    }

    private void loadState() {
        String errorMsg = "Machine: Fail to load state";
        boolean succeed = false;
        State state = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(STATE_FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            state = (State) objectInputStream.readObject();
            objectInputStream.close();
            succeed = state == null ? false : true;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Machine: got exception: " + e);
            e.printStackTrace();
        }

        if (succeed) {
            System.out.println("read state: " + state);
            changeState(state);
        } else {
            System.out.println(errorMsg);
        }
    }
}