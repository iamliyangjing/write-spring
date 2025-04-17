package cn.write.springframework.test.proxy;




import cn.write.springframework.test.aop.beans.IUserService;

import java.util.Random;

/**
 * @Title: UserService
 * @Author cooper.li
 * @Package cn.write.springframework.test.proxy
 * @Date 2025/4/17 20:55
 * @description:
 */
public class UserService implements IUserService {

    private String token;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "小傅哥，100001，深圳，" + token;
    }

    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
