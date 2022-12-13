package cn.write.springframework.test.bean;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-13 17:38
 **/
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public UserService() {
        this.name = name;
    }
    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}
