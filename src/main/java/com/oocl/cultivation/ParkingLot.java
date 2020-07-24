package com.oocl.cultivation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ParkingLot {
    private final Map<CarTicket, Car> parkingRoom = new HashMap<>();
    private final Set<CarTicket> carTicketRecords = new HashSet<>();

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        parkingRoom.put(carTicket, car);
        return carTicket;
    }

    public Car fetch(CarTicket ticket) {
        if(carTicketRecords.contains(ticket)){
            return null;
        }
        carTicketRecords.add(ticket);
        return parkingRoom.get(ticket);
    }
}
