package com.learning.controller;

import com.learning.factory.ElevatorFactory;
import com.learning.model.Elevator;
import com.learning.model.RequestDirection;
import com.learning.strategy.ElevatorSelection;
import com.learning.strategy.ElevatorSelectionStrategy1;

public class ElevatorFactoryImpl implements ElevatorFactory {
    private Elevator[] elevators;
    private final Integer minFloor;
    private final Integer maxFloor;
    private ElevatorSelection elevatorSelection = new ElevatorSelection(new ElevatorSelectionStrategy1());

    public ElevatorFactoryImpl(Integer elevatorCount, Integer minFloor, Integer maxFloor){
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        if(elevatorCount < 1){
            //Throw exception
        } else {
            this.elevators = new Elevator[elevatorCount];
            for(int i=0;i<elevatorCount;i++){
                elevators[i] = new Elevator(0, i);
            }
        }
    }

    @Override
    public Elevator requestElevator(RequestDirection requestDirection, Integer floorNo) {
        Elevator selectedElevator = elevatorSelection.requestElevator(requestDirection, floorNo, elevators);
        if(selectedElevator==null){
            //wait for few seconds and retry
            return selectedElevator;
        } else {
            selectedElevator.addDestinationFloor(floorNo);
            return selectedElevator;
        }

    }

//    @Override
//    public void requestDestination(Integer floor, Elevator elevator) {
//            elevator.addDestinationFloor(floor);
//    }
}
