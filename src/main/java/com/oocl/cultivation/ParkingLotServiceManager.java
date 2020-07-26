package com.oocl.cultivation;

public class ParkingLotServiceManager {
    private IServiceStrategy serviceStrategy;

    public ParkingLotServiceManager(IServiceStrategy serviceStrategy) {
        this.serviceStrategy = serviceStrategy;
    }

    public Object doService(Object param) throws CustomException {
        return serviceStrategy.doService(param);
    }
}
