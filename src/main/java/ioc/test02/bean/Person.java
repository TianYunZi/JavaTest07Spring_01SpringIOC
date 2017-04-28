package ioc.test02.bean;

import ioc.test02.annotation.Bean;
import ioc.test02.annotation.Param;
import ioc.test02.annotation.Service;

/**
 * Created by Admin on 2017/4/28.
 */
@Bean(name = "person")
public class Person {

    @Bean(name = "car")
    private Car car;

    @Service(name = "ToSomeWhere")
    public String toSomeWhere(@Param(name = "address") String address) {
        return car.driveToSomeWhere(address);
    }

    @Service(name = "ToSomeWhere2")
    public String toSomeWhere2(@Param(name = "address2") String address2) {
        return car.driveToSomeWhere(address2);
    }
}
