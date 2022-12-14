package cn.write.springframework.context.support;

import cn.write.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.write.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-14 14:12
 **/
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(String.valueOf(configLocations));
        }
    }

    protected abstract String[] getConfigLocations();
}
