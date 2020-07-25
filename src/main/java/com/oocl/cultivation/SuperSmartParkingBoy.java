package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SuperSmartParkingBoy extends ParkingBoy {
    private List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public CarTicket park(Car car) throws CustomException {
        List<Integer> remindCapacities = parkingLots.stream().map(ParkingLot::getParkingRoomRemindCapacity).collect(Collectors.toList());
        List<Integer> totalCapacities = parkingLots.stream().map(ParkingLot::getCapacity).collect(Collectors.toList());
        List<Double> maximumUtilizationList = new ArrayList<>();
        for (int i = 0; i < parkingLots.size(); i++) {
            maximumUtilizationList.add(getMaximumUtilization(remindCapacities.get(i), totalCapacities.get(i)));
        }
        Double maximumUtilization = maximumUtilizationList.stream().reduce(Double::max).get();
        int theIndexOfMaximumUtilization = maximumUtilizationList.indexOf(maximumUtilization);
        return parkingLots.get(theIndexOfMaximumUtilization).park(car);
    }

    private Double getMaximumUtilization(int remindCapacity, int capacity) {
        return (double) remindCapacity / (double) capacity;
    }
}
