package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingLotServiceManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotServiceManagerTest {
    @Test
    void should_return_void_when_append_parking_boy_given_parking_boy() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager();
        // when
        parkingLotServiceManager.appendParkingBoy(parkingBoy);
        // then
        assertEquals(parkingLotServiceManager.getParkingLot(), parkingBoy.getParkingLot());
    }

    @Test
    void should_return_parking_boy_when_specify_parking_boy_given_parking_lot_service_manager() {
        // given
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager();
        ParkingLot parkingLot = parkingLotServiceManager.getParkingLot();
        // when
        ParkingBoy specifiedParkingBoy =parkingLotServiceManager.specifyParkingBoy(parkingLot);
        // then
        assertNotNull(specifiedParkingBoy);
        assertEquals(parkingLot, specifiedParkingBoy.getParkingLot());
    }
}
