package home;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import home.dao.UserDao;
import home.domain.User;

public class TestUserController {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ctx=null;
        ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao=(UserDao) ctx.getBean("userDao");
        User user=new User();
        //添加两条数据
        user.setId(1);
        user.setName("Jessica");
        user.setPassword("123");
        user.setId(2);
        user.setName("Jessica2");
        user.setPassword("123");
        System.out.println("添加成功");
        //查询数据
        user.setName("Jessica");
        user.setPassword("123");
        user.setName("Jessica2");
        user.setPassword("123");
        //修改数据
        user.setId(2);
        user.setPassword("802");
        System.out.println("修改成功");
        //删除数据
        System.out.println("删除成功");
        
    }

}
