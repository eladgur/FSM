package com.elad.framework.interfaces;

import com.elad.framework.component.Event;

public interface Observable {

    void notify(Event event) ;

    void addObserver(Observer observer);
}