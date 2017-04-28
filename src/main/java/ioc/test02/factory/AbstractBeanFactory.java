package ioc.test02.factory;

import ioc.test02.data.DataContext;

import java.io.Serializable;

/**
 * Created by Admin on 2017/4/28.
 *
 * @Description : 抽象的服务工厂，定义处理服务的算法骨架，具体由其子类实现。
 * 使用模板方法模式定义算法的骨架，具体实现有相应的子类去做。
 */
public abstract class AbstractBeanFactory implements BeanFactory, Serializable {

    //----------组件初始化----------begin-----

    protected DataContext beanDefinitionContext;//服务描述信息的存储区
    protected DataContext beanCacheContext; //服务提供者实例的缓存区
    // TODO: 2017/4/28 HandlerDecorator 
}
