package ioc.test02.entity;

import java.util.List;

/**
 * Created by Admin on 2017/4/28.
 * @Description :服务提供者描述信息载体，其数据结构如下：
 *
 *                                       BeanEntity
 *
 *                     name               type                      List
 *                   @bean注解名          Bean类型              ServicEntity的arrayList
 *                                                     ServiceEntity……
 *
 *                                                 name           value               List
 *                                              @Service注解名      方法名          ParamEntity的ArrayList
 *                                                                               ParamEntity……
 *                                                                             name            value
 *                                                                           @param注解名       参数类型
 */
public class BeanEntity {

    private String name;  //服务提供者名
    private String type;  //服务提供者实例的类型
    private Object value;  //服务提供者实例
    private List<ServiceEntity> serviceEntityList;//服务提供者提供的所有服务

    public BeanEntity() {
    }

    public BeanEntity(String name, String type, Object value, List<ServiceEntity> serviceEntityList) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.serviceEntityList = serviceEntityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public List<ServiceEntity> getServiceEntityList() {
        return serviceEntityList;
    }

    public void setServiceEntityList(List<ServiceEntity> serviceEntityList) {
        this.serviceEntityList = serviceEntityList;
    }
}
