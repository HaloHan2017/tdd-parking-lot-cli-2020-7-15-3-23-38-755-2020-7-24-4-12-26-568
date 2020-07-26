package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingLotServiceManagerTest {
    @Test
    void should_return_void_when_append_parking_boy_given_parking_boy() throws CustomException {
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
    void should_return_parking_boy_when_specify_parking_boy_given_parking_lot_service_manager() throws CustomException {
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

    @Test
    void should_return_car_ticket_when_park_given_car() throws CustomException {
        // given
        CarServiceStrategy carServiceStrategy = new CarServiceStrategy();
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(carServiceStrategy);
        Car car = new Car();
        // when
        CarTicket carTicket = (CarTicket) parkingLotServiceManager.doService(car);
        // then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_car_when_fetch_given_car_ticket() throws CustomException {
        // given
        CarServiceStrategy carServiceStrategy = new CarServiceStrategy();
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(carServiceStrategy);
        Car car = new Car();
        CarTicket carTicket = (CarTicket) parkingLotServiceManager.doService(car);
        // when
        Car fetchedCar = (Car) parkingLotServiceManager.doService(carTicket);
        // then
        assertNotNull(fetchedCar);
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_return_car_ticket_when_assign_parking_boy_task_given_car() throws CustomException {
        // given
        UserServiceStrategy userServiceStrategy = new UserServiceStrategy();
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(userServiceStrategy);
        for (int i = 0; i < 10; i++) {
            parkingLotServiceManager.doService(new Car());
        }
        // when
        String errorMsg = (String) parkingLotServiceManager.doService(new Car());
        // then
        assertEquals("Not enough position.", errorMsg);
    }

    @Test
    void should_return_car_when_assign_parking_boy_task_given_car() throws CustomException {
        // given
        UserServiceStrategy userServiceStrategy = new UserServiceStrategy();
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(userServiceStrategy);
        CarTicket carTicket = (CarTicket) parkingLotServiceManager.doService(new Car());
        CarTicket wrongCarTicket = new CarTicket();
        // when
        String errorMsg = (String) parkingLotServiceManager.doService(wrongCarTicket);
        // then
        assertEquals("Unrecognized parking ticket.", errorMsg);
    }
}
