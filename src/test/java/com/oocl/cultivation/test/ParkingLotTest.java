package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.CustomException;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void should_return_car_ticket_when_park_given_car() throws CustomException {
        // given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        // when
        CarTicket ticket = parkingLot.park(car);
        // then
        assertNotNull(ticket);
    }

    @Test
    void should_return_null_when_park_given_repeat_car() throws CustomException {
        // given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        // when
        CarTicket ticketOnce = parkingLot.park(car);
        CarTicket ticketTwice = parkingLot.park(car);
        // then
        assertNotNull(ticketOnce);
        assertNull(ticketTwice);
    }

    @Test
    void should_return_fetch_car_when_fetch_given_car_ticket() throws CustomException {
        // given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket ticket = parkingLot.park(car);
        // when
        Car fetchedCar = parkingLot.fetch(ticket);
        // then
        assertNotNull(fetchedCar);
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_get_error_msg_when_fetch_given_wrong_car_ticket() throws CustomException {
        // given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.park(car);
        CarTicket wrongTicket = new CarTicket();
        // when
        Throwable exception = assertThrows(CustomException.class, () -> {
            parkingLot.fetch(wrongTicket);
        });
        // then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_get_error_info_when_fetch_given_null_car_ticket() throws CustomException {
        // given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.park(car);
        // when
        Throwable exception = assertThrows(CustomException.class, () -> {
            parkingLot.fetch(null);
        });
        // then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_get_error_info_when_fetch_given_used_car_ticket() throws CustomException {
        // given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket = parkingLot.park(car);
        // when
        Throwable exception = assertThrows(CustomException.class, () -> {
            parkingLot.fetch(carTicket);
            parkingLot.fetch(carTicket);
        });
        // then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_return_null_when_park_given_parking_room_is_full() {
        // given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        // when
        Throwable exception = assertThrows(CustomException.class, () -> {
            for (int i = 0; i < 10; i++) {
                parkingLot.park(new Car());
            }
            parkingLot.park(car);
        });
        // then
        assertEquals("Not enough position.", exception.getMessage());
    }
}
