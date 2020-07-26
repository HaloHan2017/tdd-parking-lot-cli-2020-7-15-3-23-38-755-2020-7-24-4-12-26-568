package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotServiceManager {
    private ParkingLot parkingLot;
    private List<ParkingBoy> parkingBoys;

    public ParkingLotServiceManager() {
        parkingLot = new ParkingLot();
        parkingBoys = new ArrayList<>();
        initParkingBoys();
    }

    private void initParkingBoys() {
        for (ParkingBoy parkingBoy : parkingBoys) {
            parkingBoy.setParkingLot(parkingLot);
        }
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void appendParkingBoy(ParkingBoy parkingBoy) {
        parkingBoy.setParkingLot(parkingLot);
        parkingBoys.add(parkingBoy);
    }

    public ParkingBoy specifyParkingBoy() {
        if(parkingBoys.isEmpty()){
            return null;
        }
        return parkingBoys.get(0);
    }
}
