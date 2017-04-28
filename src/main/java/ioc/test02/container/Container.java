package ioc.test02.container;

import ioc.test02.data.DataContext;
import ioc.test02.entity.BeanEntity;

/**
 * Created by Admin on 2017/4/28.
 *
 * @Description :容器的核心接口
 */
public interface Container {

    //获取容器的某个服务提供者实例
    Object getBean();

    //根据服务提供者名称，服务名称，参数来获取容器提供的服务
    //由三者确定一个唯一的服务。
    Object getService(String beanName, String serviceName, Object... args);

    //获取容器所有服务描述信息
    DataContext getBeanDefinitionContext();

    //获取容器中某个服务提供者的描述信息
    BeanEntity getBeanDefinition(String name);

    //获取容器中所有服务提供者实例的缓存
    public DataContext getBeanCacheContext();

    //热加载新的服务提供者
    public void initContainerService(String resource);
}
