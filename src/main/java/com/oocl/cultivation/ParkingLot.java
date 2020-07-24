package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<CarTicket, Car> parkingRoom = new HashMap<>();
    private final int THE_CAPACITY_OF_PARKING_ROOM = 10;

    public CarTicket park(Car car) {
        if(parkingRoom.size() >= THE_CAPACITY_OF_PARKING_ROOM || parkingRoom.values().contains(car)){
            return null;
        }
        CarTicket carTicket = new CarTicket();
        parkingRoom.put(carTicket, car);
        return carTicket;
    }

    public Car fetch(CarTicket ticket) {
        if(parkingRoom.get(ticket) == null){
            return null;
        }
        return parkingRoom.remove(ticket);
    }
}
