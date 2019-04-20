package com.elad.framework.interfaces;

import com.elad.framework.component.Event;

public interface Observer {

    void update(Event event);
}