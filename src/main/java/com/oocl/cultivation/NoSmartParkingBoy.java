package com.oocl.cultivation;

import java.util.List;

public class NoSmartParkingBoy extends ParkingBoy {
    private final List<ParkingLot> parkingLots;

    public NoSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public CarTicket park(Car car) throws CustomException {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getParkingRoomRemindCapacity() > 0) {
                return parkingLot.park(car);
            }
        }
        throw new CustomException("Not enough position.");
    }
}
