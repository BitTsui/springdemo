package tsui.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tsui.service.UserService;

public class Demo01 {
    @Test
    public void test1(){
        //以前用UserService的方式，自己创建对象
        /*UserService userService = new UserServiceImpl();
        userService.setName("崔烁豪");
        userService.add();*/

        //现在使用UserService的方式，从spring容器获取
        //1.加载beans.xml这个spring的配置文件，spring容器中就会创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //2、从spring容器获取userService对象，接口实例化对象并指向spring容器中的实现对象
        //getBean中的值要与beans.xml中bean的id的值一致
        //接口实例化对象可以随意命名
        UserService userServicedemo = (UserService)context.getBean("userService");
        //3、测试一下userService对象是否正常
//        userServicedemo.setName("张依方");
        userServicedemo.add();
    }
}
