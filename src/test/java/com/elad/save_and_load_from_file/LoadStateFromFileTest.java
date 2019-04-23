package com.elad.save_and_load_from_file;

import com.elad.framework.components.Machine;
import org.junit.Assert;
import org.junit.Test;

public class LoadStateFromFileTest {

    private static final String MACHINE_FILE_NAME = "machine.ser";

    @Test
    public void test() {
        save();
        load();
    }

    public void save() {
        Machine machine = new Machine(new DemoState());
        machine.saveToFile(MACHINE_FILE_NAME);
    }

    public void load() {
        Machine machine = null;
        try {
            machine = Machine.loadFromFile(MACHINE_FILE_NAME);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Fail to assert that Machine load the demo state",
                machine.getState().getClass(), DemoState.class);
    }
}
