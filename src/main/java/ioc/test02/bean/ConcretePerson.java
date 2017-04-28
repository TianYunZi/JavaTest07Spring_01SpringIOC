package ioc.test02.bean;

import ioc.test02.annotation.Bean;
import ioc.test02.annotation.Param;
import ioc.test02.annotation.Service;

/**
 * Created by Admin on 2017/4/28.
 */
@Bean(name = "zhangsan")
public class ConcretePerson {

    @Bean(name = "person")
    private Person person;

    @Service(name = "ToSomeWhere")
    public String toSomeWhere(@Param(name = "address") String address) {
        return person.toSomeWhere(address);
    }
}
