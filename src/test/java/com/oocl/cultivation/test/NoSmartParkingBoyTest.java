package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NoSmartParkingBoyTest {

    @Test
    void should_return_car_ticket_when_park_sequentially_given_car() throws CustomException {
        // given
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            parkingLots.add(new ParkingLot());
        }
        NoSmartParkingBoy noSmartParkingBoy = new NoSmartParkingBoy(parkingLots);
        // when
        CarTicket ticket = noSmartParkingBoy.park(car);
        // then
        assertNotNull(ticket);
        assertEquals(9, parkingLots.get(0).getParkingRoomRemindCapacity());
        assertEquals(10, parkingLots.get(1).getParkingRoomRemindCapacity());
    }
}
