package com.learning.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElevatorTest {
    private Elevator elevator;

    @BeforeEach
    public void initializeElevator(){
        elevator = new Elevator(0,0);
    }

    @Test
    public void testMovingUp(){
        elevator.addDestinationFloor(5);
        elevator.move();
        assertEquals(1, elevator.getCurrentFloor());
        assertEquals(ElevatorDirection.MOVING_UP, elevator.getDirection());
    }

    @Test
    public void testMovingDown(){
        elevator.addDestinationFloor(-1);
        elevator.move();
        assertEquals(-1, elevator.getCurrentFloor());
        assertEquals(ElevatorDirection.MOVING_DOWN, elevator.getDirection());
    }
}
