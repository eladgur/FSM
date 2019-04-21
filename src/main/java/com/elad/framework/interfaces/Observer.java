package com.elad.framework.interfaces;

import com.elad.framework.components.Event;

public interface Observer {

    void update(Event event);
}