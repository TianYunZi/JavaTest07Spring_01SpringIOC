package ioc.test01.service;

import ioc.test01.dao.Car;

/**
 * Created by Admin on 2017/4/25.
 */
public class CarServiceImpl implements CarService {

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void sell() {
        car.cleanCar();
    }
}
