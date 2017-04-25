package ioc.test01.realize;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 2017/4/25.
 */
public class SelfClassPathXMLApplicationContext {

    private List<BeanObject> beanObjects = new ArrayList<>();
    private Map<String, Object> singletons = new HashMap<>();

    public SelfClassPathXMLApplicationContext(String fileName) {
        // TODO: 2017/4/25  
    }

    /**
     * 为bean对象的属性注入值
     */
    private void injectObject() {
        beanObjects.forEach(e -> {
            Object bean = singletons.get(e.getId());//private Map<String, Object> singletons = new HashMap<>();
            if (bean != null) {
                try {
                    PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();
                    for (AttributeObject property : e.getList()) {
                        for (PropertyDescriptor descriptor : propertyDescriptors) {
                            if (property.getName().equals(descriptor.getName())) {
                                //获取属性的setter方法
                                Method setter = descriptor.getWriteMethod();
                                if (setter != null) {
                                    Object value = singletons.get(property.getRef());
                                    setter.setAccessible(true);
                                    setter.invoke(bean, value);
                                }
                                break;
                            }
                        }
                    }
                } catch (IntrospectionException e1) {
                    e1.printStackTrace();
                } catch (InvocationTargetException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    /**
     * 完成bean实例化
     */
    private void instanceBeans() {
        beanObjects.forEach(e -> {
            String className = e.getClassName().trim();
            if (className != null && !className.equals("")) {
                try {
                    singletons.put(e.getId(), Class.forName(e.getClassName()).newInstance());
                } catch (InstantiationException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    /**
     * 读取xml配置文件
     *
     * @param filename
     */
    private void readXml(String filename) {
        //创建xml解析对象
        SAXReader saxReader = new SAXReader();
        Document document = null;
        //filename不能以'/'开头时,path是从ClassPath根下获取
        URL xmlPath = this.getClass().getClassLoader().getResource(filename);
        try {
            //读取XML文件,获得document对象
            document = saxReader.read(xmlPath);
            Map<String, String> namespaceMap = new HashMap<>();
            //加入命名空间
            namespaceMap.put("ns", "http://www.yours.org/beans");
            //创建beans/bean查询路径
            XPath xPath = document.createXPath("//ns:beans/ns:bean");
            //设置命名空间
            xPath.setNamespaceURIs(namespaceMap);
            //获取文档下所有bean节点
            List<Element> beans = xPath.selectNodes(document);
            for (Element element : beans) {
                //获取id属性值
                String id = element.attributeValue("id");
                //获取class属性值
                String clazz = element.attributeValue("class");
                BeanObject beanObject = new BeanObject(id, clazz);
                XPath propertysub = element.createXPath("ns:property");
                //设置命名空间
                propertysub.setNamespaceURIs(namespaceMap);
                List<Element> properties = propertysub.selectNodes(element);
                // TODO: 2017/4/25  
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
