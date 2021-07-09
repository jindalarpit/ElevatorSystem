package com.learning.interfaces;

import com.learning.model.ElevatorDirection;

public interface ElevatorInterface {
    public int getCurrentFloor();
    public void addDestinationFloor(Integer floor);
    public ElevatorDirection getDirection();
    public void move();
}
