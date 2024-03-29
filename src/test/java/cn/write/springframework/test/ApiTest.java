package cn.write.springframework.test;

import cn.hutool.core.io.IoUtil;
import cn.write.springframework.beans.PropertyValue;
import cn.write.springframework.beans.PropertyValues;
import cn.write.springframework.beans.factory.config.BeanDefinition;
import cn.write.springframework.beans.factory.config.BeanReference;
import cn.write.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.write.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.write.springframework.context.ApplicationContext;
import cn.write.springframework.context.support.ClassPathXmlApplicationContext;
import cn.write.springframework.core.io.DefaultResourceLoader;
import cn.write.springframework.core.io.Resource;
import cn.write.springframework.test.aop.beans.IUserService;
import cn.write.springframework.test.bean.UserDao;
import cn.write.springframework.test.bean.UserService;
import cn.write.springframework.test.common.MyBeanFactoryPostProcessor;
import cn.write.springframework.test.common.MyBeanPostProcessor;
import cn.write.springframework.test.event.CustomEvent;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


/**
 * @program: write-spring
 * @description: 测试
 * @author: lyj
 * @create: 2022-12-13 17:38
 **/
public class ApiTest {
    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService", "小傅哥");
        userService.queryUserInfo();
    }


    @Test
    public void test_newInstance() throws IllegalAccessException, InstantiationException {
        UserService userService = UserService.class.newInstance();
        System.out.println(userService);
    }

    @Test
    public void test_BeanFactory_05() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }


    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        // 网络原因可能导致GitHub不能读取，可以放到自己的Gitee仓库。读取后可以从内容中搜索关键字；OLpj9823dZ
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/blob/main/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring-property.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("src/test/resources/spring-property.xml");

        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }


    @Test
    public void test_xml1() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

//    @Test
//    public void test_xml2() {
//        // 1.初始化 BeanFactory
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
//        applicationContext.registerShutdownHook();
//
//        // 2. 获取Bean对象调用方法
//        UserService userService = applicationContext.getBean("userService", UserService.class);
//        String result = userService.queryUserInfo();
//        System.out.println("测试结果：" + result);
//        System.out.println("ApplicationContextAware："+userService.getApplicationContext());
//        ApplicationContext applicationContext1 = userService.getApplicationContext();
//        System.out.println(applicationContext1.getBean("userDao"));
//        System.out.println("BeanFactoryAware："+userService.getBeanFactory());
//    }


    @Test
    public void test_prototype() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);

        // 4. 打印十六进制哈希
        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));

    }


    @Test
    public void test_factory_bean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        applicationContext.registerShutdownHook();

        // 2. 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }



        @Test
        public void test_event() {
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
            //发布事件
            applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

            applicationContext.registerShutdownHook();
        }


    @Test
    public void test_property() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService);
    }

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }


}
