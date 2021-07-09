package com.fidality;

import com.fidality.controller.ElevatorFactoryImpl;
import com.fidality.model.Elevator;
import com.fidality.model.RequestDirection;

public class ElevatorControlSystem {
    public static final Integer REQUEST_FROM_FLOOR = 5;
    public static final Integer DESTINATION_FLOOR = 9;
    public static void main(String[] args){
        ElevatorFactoryImpl elavtorSystem = new ElevatorFactoryImpl(5, -1, 30);
        Elevator e = elavtorSystem.requestElevator(RequestDirection.UP, REQUEST_FROM_FLOOR);
        while(e.getCurrentFloor()!=REQUEST_FROM_FLOOR) {
            e.move();
            System.out.println("Elevator is at Floor Number:" + e.getCurrentFloor());
        }
        System.out.println("Elevator reached requested floor");
        e.addDestinationFloor(DESTINATION_FLOOR);
        while(e.getCurrentFloor()!=DESTINATION_FLOOR) {
            e.move();
            System.out.println("Elevator is at Floor Number:" + e.getCurrentFloor());
        }
        System.out.println("Elevator reached destination floor");
    }
}