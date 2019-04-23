package com.elad.framework.components;

import com.elad.framework.interfaces.StateContext;
import com.elad.framework.interfaces.Observer;

import java.io.*;

public class Machine implements Observer, StateContext, Serializable {

    private State state;

    public static Machine loadFromFile(String fileName) throws InstantiationException {
        String errorMsg = "Machine: Fail to load machine from file: " + fileName;
        Machine machine = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            machine = (Machine) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Machine: got exception while loading from file: " + e);
            e.printStackTrace();
        }

        if (machine == null) {
            throw new InstantiationException(errorMsg);
        } else {
            return machine;
        }
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

    public void saveToFile(String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("Machine: Fail to save state");
            e.printStackTrace();
        }
    }
}