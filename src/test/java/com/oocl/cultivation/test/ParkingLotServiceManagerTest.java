package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingBoyServiceStrategy;
import com.oocl.cultivation.ParkingLotServiceManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingLotServiceManagerTest {
    @Test
    void should_return_void_when_append_parking_boy_given_parking_boy() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingBoyServiceStrategy parkingBoyServiceStrategy = new ParkingBoyServiceStrategy();
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingBoyServiceStrategy);
        // when
        parkingLotServiceManager.doService(parkingBoy);
        // then
        assertEquals(parkingBoyServiceStrategy.getParkingLot(), parkingBoy.getParkingLot());
    }

    @Test
    void should_return_parking_boy_when_specify_parking_boy_given_parking_lot_service_manager() {
        // given
        ParkingBoyServiceStrategy parkingBoyServiceStrategy = new ParkingBoyServiceStrategy();
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingBoyServiceStrategy);
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingLotServiceManager.doService(parkingBoy);
        // when
        ParkingBoy specifiedParkingBoy = (ParkingBoy) parkingLotServiceManager.doService(null);
        // then
        assertNotNull(specifiedParkingBoy);
        assertEquals(parkingBoy, specifiedParkingBoy);
        assertEquals(parkingBoyServiceStrategy.getParkingLot(), specifiedParkingBoy.getParkingLot());
    }
}
