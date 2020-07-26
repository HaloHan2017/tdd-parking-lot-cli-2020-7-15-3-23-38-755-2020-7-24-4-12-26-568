package com.oocl.cultivation;

public class CarServiceStrategy extends ParkingBoy implements IServiceStrategy {
    @Override
    public Object doService(Object param) {
        return null;
    }

    @Override
    public CarTicket park(Car car) throws CustomException {
        return super.park(car);
    }
}
