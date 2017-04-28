package ioc.test02.entity;

/**
 * Created by Admin on 2017/4/28.
 */
public class ParamEntity {

    private String name; //参数名
    private String value; //参数的类型

    public ParamEntity() {
    }

    public ParamEntity(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
