package com.oocl.cultivation;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy() {
        this.parkingLot = new ParkingLot();
    }

    public CarTicket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(CarTicket ticket) {
        return parkingLot.fetch(ticket);
    }
}
