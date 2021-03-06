package ioc.test02.factory;

/**
 * Created by Admin on 2017/4/28.
 *
 * @Description :  容器的核心工厂接口
 */
public interface BeanFactory {

    /**
     * 根据服务提供者的名字获取服务提供者的实例
     *
     * @param name 服务提供者的名字
     * @return 服务提供者的实例
     */
    Object getBean(String name);

    /**
     * 初始化工厂，注册服务
     *
     * @param resource          默认元数据的位置（实质是一个包的路径），可以自定义
     * @param cacheContext      默认服务提供者实例的缓存区 （缓存），可以自定义
     * @param definitionContext 默认服务描述信息的存储区（类似Jndi），可以自定义
     * @param defaultHandler    默认处理器，负责将《元数据》转换为《服务描述信息》。不能被替换，可以再其前累加自定义处理器
     * @param customHandler     自定义处理器，先使用默认处理器处理元数据，然后再使用自定义处理器
     */
    void registerBeanDefinition(String resource, String cacheContext, String definitionContext, String defaultHandler, String customHandler);
}
