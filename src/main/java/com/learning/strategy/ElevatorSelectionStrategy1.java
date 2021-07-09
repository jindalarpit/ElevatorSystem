package com.learning.strategy;

import com.learning.model.Elevator;
import com.learning.model.ElevatorDirection;
import com.learning.model.RequestDirection;

public class ElevatorSelectionStrategy1 implements ElevatorSelectionStrategy{
    @Override
    public Elevator requestElevator(RequestDirection requestDirection, Integer floorNo, Elevator[] elevators) {
        Integer distanceFromMovingElevator = Integer.MAX_VALUE;
        Integer distanceFromStoppedElevator = Integer.MAX_VALUE;
        Elevator NearestMovingElevator = null;
        Elevator NearestStoppedElevator = null;
        for(Elevator e: elevators) {
            if (requestDirection == RequestDirection.UP) {
                if (e.getDirection() == ElevatorDirection.MOVING_UP && e.getCurrentFloor() < floorNo) {
                    Integer distanceFromCurrentElevator = floorNo - e.getCurrentFloor();
                    if (distanceFromCurrentElevator < distanceFromMovingElevator) {
                        distanceFromMovingElevator = distanceFromCurrentElevator;
                        NearestMovingElevator = e;
                    }
                }
            } else {
                if (e.getDirection() == ElevatorDirection.MOVING_DOWN && e.getCurrentFloor() > floorNo) {
                    Integer distanceFromCurrentElevator = e.getCurrentFloor() - floorNo;
                    if (distanceFromCurrentElevator < distanceFromMovingElevator) {
                        distanceFromMovingElevator = distanceFromCurrentElevator;
                        NearestMovingElevator = e;
                    }
                }
            }
            //Stopped Elevator
                Integer distanceFromCurrentElevator = Math.abs(floorNo - e.getCurrentFloor());
                if (distanceFromCurrentElevator < distanceFromStoppedElevator) {
                    distanceFromStoppedElevator = distanceFromCurrentElevator;
                    NearestStoppedElevator = e;
                }


        }
        if(distanceFromMovingElevator==Integer.MAX_VALUE && distanceFromStoppedElevator==Integer.MAX_VALUE){
            return null;
        }
        else if(distanceFromMovingElevator!=Integer.MAX_VALUE && distanceFromMovingElevator<distanceFromStoppedElevator){
            return NearestMovingElevator;
        } else {
            return NearestStoppedElevator;
        }

    }
}
