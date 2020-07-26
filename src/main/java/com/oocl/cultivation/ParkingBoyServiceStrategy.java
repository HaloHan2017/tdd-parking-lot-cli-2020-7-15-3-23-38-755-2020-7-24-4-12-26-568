package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParkingBoyServiceStrategy implements IServiceStrategy {
    private ParkingLot parkingLot;
    private List<ParkingBoy> parkingBoys;

    public ParkingBoyServiceStrategy() {
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
        if (parkingBoys.isEmpty()) {
            return null;
        }
        return parkingBoys.get(0);
    }

    @Override
    public Object doService(Object param) {
        if (Objects.isNull(param)) {
            return specifyParkingBoy();
        }
        appendParkingBoy((ParkingBoy) param);
        return null;
    }
}
