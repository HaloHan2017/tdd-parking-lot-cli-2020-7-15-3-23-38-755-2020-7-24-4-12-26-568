package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.CustomException;
import com.oocl.cultivation.ParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    void should_return_car_ticket_when_park_given_car() throws CustomException {
        // given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        // when
        CarTicket ticket = parkingBoy.park(car);
        // then
        assertNotNull(ticket);
    }

    @Test
    void should_return_fetch_car_when_fetch_given_car_ticket() throws CustomException {
        // given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        CarTicket ticket = parkingBoy.park(car);
        // when
        Car fetchedCar = parkingBoy.fetch(ticket);
        // then
        assertNotNull(fetchedCar);
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_get_exception_message_of_unrecognized_parking_ticket_when_fetch_given_wrong_car_ticket() throws CustomException {
        // given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        CarTicket carTicket = parkingBoy.park(car);
        CarTicket wrongCarTicket = new CarTicket();
        // when
        AtomicReference<Car> fetchedCarAtomicReference = new AtomicReference<>();
        Throwable exception = assertThrows(CustomException.class, () -> {
            fetchedCarAtomicReference.set(parkingBoy.fetch(wrongCarTicket));
        });
        assertNull(fetchedCarAtomicReference.get());
        assertNotEquals(carTicket, wrongCarTicket);
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_get_exception_message_of_please_provide_your_parking_ticket_when_fetch_given_null_car_ticket() throws CustomException {
        // given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.park(car);
        // when
        Throwable exception = assertThrows(CustomException.class, () -> {
            parkingBoy.fetch(null);
        });
        assertEquals("Please provide your parking ticket.", exception.getMessage());
    }

    @Test
    void should_get_exception_message_of_not_enough_position_when_park_given_car() throws CustomException {
        // given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        // when
        for (int i = 0; i < 10; i++) {
            parkingBoy.park(new Car());
        }
        Throwable exception = assertThrows(CustomException.class, () -> {
            parkingBoy.park(car);
        });
        // then
        assertEquals("Not enough position.", exception.getMessage());
    }
}
