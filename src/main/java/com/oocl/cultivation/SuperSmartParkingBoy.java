package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    private List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public CarTicket park(Car car) throws CustomException {
        ParkingLot parkingLot = parkingLots.stream().max(Comparator.comparingDouble(ParkingLot::getMaximumUtilization)).orElse(null);
        return parkingLot.park(car);
    }
}
