package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartParkingBoyTest {

    @Test
    void should_return_car_ticket_when_park_smartly_given_car() throws CustomException {
        // given
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            parkingLots.add(new ParkingLot());
        }
        for (int i = 0; i < 5; i++) {
            parkingLots.get(0).park(new Car());
        }
        for (int i = 0; i < 3; i++) {
            parkingLots.get(1).park(new Car());
        }
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        // when
        CarTicket ticket = smartParkingBoy.park(car);
        // then
        assertNotNull(ticket);
        assertEquals(5, parkingLots.get(0).getParkingRoomRemindCapacity());
        assertEquals(6, parkingLots.get(1).getParkingRoomRemindCapacity());
    }
}
