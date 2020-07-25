package com.oocl.cultivation;

import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy {
    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public CarTicket park(Car car) throws CustomException {
        List<Integer> parkingRoomRemindCapacities = parkingLots.stream().map(ParkingLot::getParkingRoomRemindCapacity).collect(Collectors.toList());
        int theMaxRemindCapacity = parkingRoomRemindCapacities.stream().reduce(Integer::max).get();
        int theIndexOfTheMaxRemindCapacity = parkingRoomRemindCapacities.indexOf(theMaxRemindCapacity);
        return parkingLots.get(theIndexOfTheMaxRemindCapacity).park(car);
    }
}
