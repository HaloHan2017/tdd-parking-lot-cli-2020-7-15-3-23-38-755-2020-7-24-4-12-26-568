package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    public void should_return_car_ticket_when_park_given_car() {
        // given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        // when
        CarTicket ticket = parkingLot.park(car);
        // then
        assertNotNull(ticket);
    }

    @Test
    public void should_return_fetch_car_when_fetch_given_car_ticket() {
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
    public void should_return_null_when_fetch_given_wrong_car_ticket() {
        // given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.park(car);
        CarTicket wrongTicket = new CarTicket();
        // when
        Car fetchedCar = parkingLot.fetch(wrongTicket);
        // then
        assertNull(fetchedCar);
    }

    @Test
    public void should_return_null_when_fetch_given_null_car_ticket() {
        // given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.park(car);
        // when
        Car fetchedCar = parkingLot.fetch(null);
        // then
        assertNull(fetchedCar);
    }
}
