package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperSmartParkingBoy extends ParkingBoy {
    private List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public CarTicket park(Car car) throws CustomException {
        Optional<ParkingLot> parkingLotOptional = parkingLots.stream().max(Comparator.comparingDouble(ParkingLot::getMaximumUtilization));
        return parkingLotOptional.isPresent() ? parkingLotOptional.get().park(car) : null;
    }
}
