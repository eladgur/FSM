package com.elad.save_and_load_from_file;

import com.elad.framework.components.Machine;
import org.junit.Assert;
import org.junit.Test;

/**
 * Instructions:
 * 1. Run save()
 * 2. Run load()
 */
public class LoadStateFromFileTest {

    @Test
    public void save() {
        Machine machine = new Machine(new DemoState());
        machine.saveState();
    }

    @Test
    public void load() {
        Machine machine = new Machine();
        Assert.assertEquals("Fail to assert that Machine load the demo state", machine.getState().getClass(), DemoState.class);
    }
}
