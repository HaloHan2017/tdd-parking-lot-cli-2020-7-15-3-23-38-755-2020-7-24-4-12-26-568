package com.oocl.cultivation;

public class UserServiceStrategy extends ParkingBoy implements IServiceStrategy {
    @Override
    public Object doService(Object param) {
        return assignParkingBoyTask(param);
    }

    private Object assignParkingBoyTask(Object param) {
        try {
            Object result = null;
            if (param instanceof Car) {
                result = park((Car) param);
            } else if (param instanceof CarTicket) {
                result = fetch((CarTicket) param);
            }
            return result;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
