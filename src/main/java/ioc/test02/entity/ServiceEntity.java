package ioc.test02.entity;

import java.util.List;

/**
 * Created by Admin on 2017/4/28.
 */
public class ServiceEntity {

    private String name; //服务名
    private String value; //服务对应的方法名
    private List<ParamEntity> paramEntityList;//服务对应方法的所有参数

    public ServiceEntity() {
    }

    public ServiceEntity(String name, String value, List<ParamEntity> paramEntityList) {
        this.name = name;
        this.value = value;
        this.paramEntityList = paramEntityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<ParamEntity> getParamEntityList() {
        return paramEntityList;
    }

    public void setParamEntityList(List<ParamEntity> paramEntityList) {
        this.paramEntityList = paramEntityList;
    }
}
