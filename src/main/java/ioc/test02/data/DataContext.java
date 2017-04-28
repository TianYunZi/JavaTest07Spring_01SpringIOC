package ioc.test02.data;

import java.util.Map;

/**
 * Created by Admin on 2017/4/28.
 *
 * @Description :抽象的数据存储接口
 */
public interface DataContext {

    void initData(Map<String, Object> map);

    void set(String string, Object object);

    Object get(String name);

    Map<String, Object> getAll();
}
