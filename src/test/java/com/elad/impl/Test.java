package com.elad.impl;

import com.elad.framework.component.Machine;
import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() {
        Machine machine = new Machine(new FirstState("A"));
        machine.update(new InputEvent("Input event", "Hello World !"));
        machine.update(new InputEvent("Input event", "Hello World !"));
        machine.update(new InputEvent("Input event", "Hello World !"));
        // Todo: assert log with warning
    }
}