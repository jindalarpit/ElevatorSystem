package com.fidality.factory;

import com.fidality.model.Elevator;
import com.fidality.model.RequestDirection;

public interface ElevatorFactory {
    public Elevator requestElevator(RequestDirection requestDirection, Integer floorNo);
    //public void requestDestination(Integer destinationFloor, Elevator elevator);
}
