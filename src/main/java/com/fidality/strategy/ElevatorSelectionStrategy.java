package com.fidality.strategy;

import com.fidality.model.Elevator;
import com.fidality.model.RequestDirection;

public interface ElevatorSelectionStrategy {
    public Elevator requestElevator(RequestDirection requestDirection, Integer floorNo, Elevator[] elevators);
}
