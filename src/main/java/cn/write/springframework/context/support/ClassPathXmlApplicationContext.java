package cn.write.springframework.context.support;

import cn.write.springframework.beans.BeansException;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-14 14:12
 **/
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     *
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    /**
     * 获取configuration Location
     * @return
     */
    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
