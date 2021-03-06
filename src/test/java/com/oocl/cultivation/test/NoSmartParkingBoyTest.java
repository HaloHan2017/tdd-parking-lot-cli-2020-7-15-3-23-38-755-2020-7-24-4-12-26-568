package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_get_exception_message_of_not_enough_position_when_park_given_car() throws CustomException {
        // given
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            parkingLots.add(new ParkingLot());
        }
        ParkingBoy noSmartParkingBoy = new NoSmartParkingBoy(parkingLots);
        // when
        for (int i = 0; i < 10; i++) {
            parkingLots.get(0).park(new Car());
            parkingLots.get(1).park(new Car());
        }
        Throwable exception = assertThrows(CustomException.class, () -> {
            noSmartParkingBoy.park(car);
        });
        // then
        assertEquals("Not enough position.", exception.getMessage());
    }
}
