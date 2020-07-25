package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
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
        Car fetchedCarByWrongCarTicket = null;
        String errorMsg = "";
        try {
            fetchedCarByWrongCarTicket = parkingBoy.fetch(wrongCarTicket);
        } catch (Exception e) {
            errorMsg = e.getMessage();
        }
        // then
        assertNull(fetchedCarByWrongCarTicket);
        assertNotEquals(carTicket, wrongCarTicket);
        assertEquals("Unrecognized parking ticket.", errorMsg);
    }

    @Test
    void should_get_exception_message_of_please_provide_your_parking_ticket_when_fetch_given_null_car_ticket() throws CustomException {
        // given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.park(car);
        // when
        String errorMsg = "";
        try {
            parkingBoy.fetch(null);
        } catch (Exception e) {
            errorMsg = e.getMessage();
        }
        // then
        assertEquals("Please provide your parking ticket.", errorMsg);
    }

    @Test
    void should_get_exception_message_of_not_enough_position_when_park_given_car() {
        // given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        // when
        String errorMsg = "";
        try {
            for (int i = 0; i < 10; i++) {
                parkingBoy.park(new Car());
            }
            parkingBoy.park(car);
        } catch (Exception e) {
            errorMsg = e.getMessage();
        }
        // then
        assertEquals("Not enough position.", errorMsg);
    }
}
