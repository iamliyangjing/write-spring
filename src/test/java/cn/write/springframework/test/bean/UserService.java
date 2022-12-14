package cn.write.springframework.test.bean;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-13 17:38
 **/
public class UserService {


    private String uId;

    private UserDao userDao;

    public String queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(uId));
        return userDao.queryUserName(uId);
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
