package com.elad.basic;

import com.elad.framework.component.Machine;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ThreeConsecutiveEventsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @org.junit.Test
    public void test() {
        Machine machine = new Machine(new ZeroEventsOccurredState());
        machine.update(new InputEvent("Input event", "Hello World !"));
        machine.update(new InputEvent("Input event", "Hello World !"));
        machine.update(new InputEvent("Input event", "Hello World !"));

        Assert.assertTrue("Fail to assert that Machine print into the log when got 3 events", outContent.toString().contains("Got 3 events"));
        Assert.assertEquals("Fail to assert that Machine got into the final state", machine.getState().getClass(), FinalState.class);
    }

    @After
    public void teardown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}