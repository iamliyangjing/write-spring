package cn.write.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-13 23:59
 **/
public interface Resource {
    public abstract InputStream getInputStream() throws IOException;
}
