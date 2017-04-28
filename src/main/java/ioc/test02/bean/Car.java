package ioc.test02.bean;

import ioc.test02.annotation.Bean;

/**
 * Created by Admin on 2017/4/28.
 */
@Bean(name = "car")
public class Car {
    public String driveToSomeWhere(String address) {
        return "Drive to" + address;
    }
}
