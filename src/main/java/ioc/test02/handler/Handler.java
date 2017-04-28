package ioc.test02.handler;

import java.util.Map;

/**
 * Created by Admin on 2017/4/28.
 *
 * @Description :装饰者模式的对象接口
 */
public interface Handler {

    //扫描指定目录下的资源，将其转化为服务描述信息，容器启动时，用这些服务描述信息初始化服务。
    Map<String,Object> convert(String string);
}
