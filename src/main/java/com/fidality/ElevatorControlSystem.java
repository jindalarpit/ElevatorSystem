package com.fidality;

import com.fidality.controller.ElevatorFactoryImpl;
import com.fidality.model.Elevator;
import com.fidality.model.RequestDirection;

public class ElevatorControlSystem {
    public static void main(String[] args){
        ElevatorFactoryImpl elavtorSystem = new ElevatorFactoryImpl(5, -1, 30);
        Elevator e = elavtorSystem.requestElevator(RequestDirection.UP, 5);

    }
}