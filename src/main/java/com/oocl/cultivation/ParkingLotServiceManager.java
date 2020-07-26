package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceManager {
    private ParkingLot parkingLot;
    private List<ParkingBoy> parkingBoys;

    public ParkingLotServiceManager() {
        parkingLot = new ParkingLot();
        parkingBoys = new ArrayList<>();
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void appendParkingBoy(ParkingBoy parkingBoy) {
        parkingBoy.setParkingLot(parkingLot);
        parkingBoys.add(parkingBoy);
    }

    public ParkingBoy specifyParkingBoy(ParkingLot parkingLot) {
        return null;
    }
}
