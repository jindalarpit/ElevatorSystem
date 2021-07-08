package com.fidality.interfaces;

import com.fidality.model.ElevatorDirection;

public interface ElevatorInterface {
    public int getCurrentFloor();
    public void addDestinationFloor(Integer floor);
    public ElevatorDirection getDirection();
    public void move();
}
