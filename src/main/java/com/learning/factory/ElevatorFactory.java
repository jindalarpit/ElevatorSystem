package com.learning.factory;

import com.learning.model.Elevator;
import com.learning.model.RequestDirection;

public interface ElevatorFactory {
    public Elevator requestElevator(RequestDirection requestDirection, Integer floorNo);
    //public void requestDestination(Integer destinationFloor, Elevator elevator);
}
