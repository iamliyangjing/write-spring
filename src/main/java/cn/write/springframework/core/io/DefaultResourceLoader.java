package cn.write.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-13 23:59
 **/
public class DefaultResourceLoader implements ResourceLoader{

    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if(location.startsWith(CLASSPATH_URL_PREFIX)){
            //从classpath中读取
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }else {
            try {
                //从url中读取
                URL url = new URL(location);
                return new UrlResource(url);
            }catch (MalformedURLException e){
                return new FileSystemResource(location);
            }
        }

    }
}
