package com.oocl.cultivation;

import java.util.Objects;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy() {
        this.parkingLot = new ParkingLot();
    }

    public CarTicket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(CarTicket ticket) throws CustomException {
        if(Objects.isNull(ticket)){
            throw new CustomException("Please provide your parking ticket.");
        }
        return parkingLot.fetch(ticket);
    }
}
