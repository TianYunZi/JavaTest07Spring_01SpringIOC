package ioc.test01.realize;

/**
 * Created by Admin on 2017/4/25.
 * 存放属性的对象，对应
 * <property name="car" ref="car"></property>
 */
public class AttributeObject {

    private String name;
    private String ref;

    public AttributeObject(String name, String ref) {
        this.name = name;
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
