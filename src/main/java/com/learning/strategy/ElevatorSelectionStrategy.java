package com.learning.strategy;

import com.learning.model.Elevator;
import com.learning.model.RequestDirection;

public interface ElevatorSelectionStrategy {
    public Elevator requestElevator(RequestDirection requestDirection, Integer floorNo, Elevator[] elevators);
}
