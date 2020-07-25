package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<CarTicket, Car> parkingRoom = new HashMap<>();
    private final int capacity = 10;

    public int getParkingRoomRemindCapacity() {
        return capacity - parkingRoom.size();
    }

    public CarTicket park(Car car) throws CustomException {
        if(parkingRoom.size() >= capacity){
            throw new CustomException("Not enough position.");
        }
        if(parkingRoom.values().contains(car)){
            return null;
        }
        CarTicket carTicket = new CarTicket();
        parkingRoom.put(carTicket, car);
        return carTicket;
    }

    public Car fetch(CarTicket ticket) throws CustomException {
        if(parkingRoom.get(ticket) == null){
            throw new CustomException("Unrecognized parking ticket.");
        }
        return parkingRoom.remove(ticket);
    }
}
