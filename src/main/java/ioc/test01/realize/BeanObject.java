package ioc.test01.realize;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/4/25.
 * 对应于xml文件中的
 * <bean id="car" class="com.ioc.dao.impl.CarImpl"></bean>
 */
public class BeanObject {

    private String id;
    private String className;

    //属性集合
    private List<AttributeObject> list = new ArrayList<>();

    public BeanObject(String id, String className) {
        this.id = id;
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<AttributeObject> getList() {
        return list;
    }

    public void setList(List<AttributeObject> list) {
        this.list = list;
    }
}
