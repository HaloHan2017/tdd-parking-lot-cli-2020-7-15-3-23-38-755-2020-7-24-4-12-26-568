package com.oocl.cultivation;

public class CarServiceStrategy extends ParkingBoy implements IServiceStrategy {
    @Override
    public Object doService(Object param) {
        try {
            if (param instanceof Car) {
                return park((Car) param);
            }
            return null;
        } catch (CustomException e) {
            return e.getMessage();
        }
    }

    @Override
    public CarTicket park(Car car) throws CustomException {
        return super.park(car);
    }
}
