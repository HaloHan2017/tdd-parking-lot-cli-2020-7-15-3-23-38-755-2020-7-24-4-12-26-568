package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<CarTicket, Car> parkingRoom = new HashMap<>();

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        parkingRoom.put(carTicket, car);
        return carTicket;
    }

    public Car fetch(CarTicket ticket) {
        return parkingRoom.get(ticket);
    }
}
