package com.learning.model;

import com.learning.interfaces.ElevatorInterface;

import java.util.Comparator;
import java.util.TreeSet;

public class Elevator implements ElevatorInterface {
    private final Integer id;
    private Integer currFloor;
    private ElevatorDirection elevatorDirection;
    private TreeSet<Integer> upDestinationFloors;
    private TreeSet<Integer> downDestinationFloors;

    public Elevator(Integer currFloor, Integer id){
        this.id = id;
        this.currFloor = currFloor;
        this.upDestinationFloors = new TreeSet<>();
        this.downDestinationFloors = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        this.elevatorDirection = ElevatorDirection.STOPPED;
    }

    @Override
    public int getCurrentFloor(){
        return this.currFloor;
    }

    @Override
    public ElevatorDirection getDirection() {
        return elevatorDirection;
    }

    @Override
    public void move() {
        if(elevatorDirection == ElevatorDirection.STOPPED){
            if(upDestinationFloors.size()>0) {
                elevatorDirection = ElevatorDirection.MOVING_UP;
                currFloor++;
            } else if (downDestinationFloors.size() > 0) {
                elevatorDirection = ElevatorDirection.MOVING_DOWN;
                currFloor--;
            }
        } else if (elevatorDirection == ElevatorDirection.MOVING_DOWN){
            currFloor--;
            if(downDestinationFloors.first() == currFloor){
                downDestinationFloors.remove(downDestinationFloors.first());
                if(downDestinationFloors.size() == 0){
                    elevatorDirection = ElevatorDirection.STOPPED;
                }
            }
        } else if (elevatorDirection == ElevatorDirection.MOVING_UP){
            currFloor++;
            if(upDestinationFloors.first() == currFloor){
                upDestinationFloors.remove(upDestinationFloors.first());
                if(upDestinationFloors.size() == 0){
                    elevatorDirection = ElevatorDirection.STOPPED;
                }
            }
        }
    }

    @Override
    public void addDestinationFloor(Integer destinationFloor){
        if(destinationFloor>currFloor){
            upDestinationFloors.add(destinationFloor);
        } else if(destinationFloor<currFloor){
            downDestinationFloors.add(destinationFloor);
        }
    }

    public Integer getId() {
        return id;
    }
}
