package com.oocl.cultivation;

public class CarServiceStrategy extends ParkingBoy implements IServiceStrategy {
    @Override
    public Object doService(Object param) {
        try {
            if (param instanceof Car) {
                return park((Car) param);
            } else if (param instanceof CarTicket) {
                return fetch((CarTicket) param);
            }
            return null;
        } catch (CustomException e) {
            return e.getMessage();
        }
    }
}
