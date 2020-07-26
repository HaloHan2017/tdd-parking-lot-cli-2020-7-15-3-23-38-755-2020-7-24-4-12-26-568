package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLotServiceManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
