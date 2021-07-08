package com.fidality.strategy;

import com.fidality.model.Elevator;
import com.fidality.model.RequestDirection;

public class ElevatorSelection {

    private ElevatorSelectionStrategy strategy;

    public ElevatorSelection(ElevatorSelectionStrategy strategy){
        this.strategy = strategy;
    }

    public Elevator requestElevator(RequestDirection requestDirection, Integer floorNo, Elevator[] elevators){
        return strategy.requestElevator(requestDirection,floorNo,elevators);
    }
}
