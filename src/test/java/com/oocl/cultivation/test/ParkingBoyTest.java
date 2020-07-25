package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_return_car_ticket_when_park_given_car() {
        // given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        // when
        CarTicket ticket = parkingBoy.park(car);
        // then
        assertNotNull(ticket);
    }

    @Test
    void should_return_fetch_car_when_fetch_given_car_ticket() {
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
    void should_return_error_info_when_fetch_given_wrong_car_ticket() {
        // given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        CarTicket carTicket = parkingBoy.park(car);
        CarTicket wrongCarTicket = new CarTicket();
        // when
        Car fetchedCarByWrongCarTicket = null;
        String errorInfo = "";
        try {
            fetchedCarByWrongCarTicket = parkingBoy.fetch(wrongCarTicket);
        }catch (Exception e){
            e.getMessage();
        }
        // then
        assertNull(fetchedCarByWrongCarTicket);
        assertNotEquals(carTicket, wrongCarTicket);
        assertEquals("Unrecognized parking ticket.",errorInfo);
    }
}
