package com.learning.strategy;

import com.learning.model.Elevator;
import com.learning.model.RequestDirection;

public class ElevatorSelection {

    private ElevatorSelectionStrategy strategy;

    public ElevatorSelection(ElevatorSelectionStrategy strategy){
        this.strategy = strategy;
    }

    public Elevator requestElevator(RequestDirection requestDirection, Integer floorNo, Elevator[] elevators){
        return strategy.requestElevator(requestDirection,floorNo,elevators);
    }
}
