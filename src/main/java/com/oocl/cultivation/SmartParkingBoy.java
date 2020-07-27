package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SmartParkingBoy extends ParkingBoy {
    private final List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public CarTicket park(Car car) throws CustomException {
        Optional<ParkingLot> parkingLotOptional = parkingLots.stream().max(Comparator.comparingDouble(ParkingLot::getParkingRoomRemindCapacity));
        return parkingLotOptional.isPresent() ? parkingLotOptional.get().park(car) : null;
    }
}
