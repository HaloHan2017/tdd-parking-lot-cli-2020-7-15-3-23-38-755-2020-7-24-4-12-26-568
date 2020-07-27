package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void should_return_error_msg_not_enough_position_when_assign_parking_boy_task_given_car() throws CustomException {
        // given
        CarServiceStrategy carServiceStrategy = new CarServiceStrategy();
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(carServiceStrategy);
        // when
        for (int i = 0; i < 10; i++) {
            parkingLotServiceManager.doService(new Car());
        }
        Throwable exception = assertThrows(CustomException.class, () -> {
            parkingLotServiceManager.doService(new Car());
        });
        // then
        assertEquals("Not enough position.", exception.getMessage());
    }

    @Test
    void should_return_error_msg_unrecognized_parking_ticket_when_assign_parking_boy_task_given_car() throws CustomException {
        // given
        CarServiceStrategy carServiceStrategy = new CarServiceStrategy();
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(carServiceStrategy);
        CarTicket carTicket = (CarTicket) parkingLotServiceManager.doService(new Car());
        CarTicket wrongCarTicket = new CarTicket();
        // when
        Throwable exception = assertThrows(CustomException.class, () -> {
            parkingLotServiceManager.doService(wrongCarTicket);
        });
        // then
        assertNotEquals(wrongCarTicket, carTicket);
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }
}
