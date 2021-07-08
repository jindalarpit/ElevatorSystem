package com.fidality.Strrategy;

import com.fidality.model.Elevator;
import com.fidality.model.RequestDirection;
import com.fidality.strategy.ElevatorSelectionStrategy;
import com.fidality.strategy.ElevatorSelectionStrategy1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestElevatorSelectionStrategy1 {
    private Elevator[] elevators = new Elevator[3];
    private ElevatorSelectionStrategy ess = new ElevatorSelectionStrategy1();
    @BeforeEach
    public void initializeElevator(){
        elevators[0] = new Elevator(0,0);
        elevators[1] = new Elevator(5,1);
        elevators[2] = new Elevator(10,2);
    }

    @Test
    public void testElevatorSelection(){
        Elevator selected  = ess.requestElevator(RequestDirection.UP, 0, elevators);
        assertEquals(0, selected.getId());
        selected  = ess.requestElevator(RequestDirection.UP, 6, elevators);
        assertEquals(1, selected.getId());
    }
}
