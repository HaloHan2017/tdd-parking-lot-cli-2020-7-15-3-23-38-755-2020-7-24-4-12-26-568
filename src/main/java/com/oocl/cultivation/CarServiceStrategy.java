package com.oocl.cultivation;

public class CarServiceStrategy extends ParkingBoy implements IServiceStrategy {
    @Override
    public Object doService(Object param) throws CustomException {
        Object result = null;
        if (param instanceof Car) {
            result = park((Car) param);
        } else if (param instanceof CarTicket) {
            result = fetch((CarTicket) param);
        }
        return result;
    }
}
