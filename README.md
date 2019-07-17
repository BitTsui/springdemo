# springdemo
我太菜了，再从头学一下spring
## day one:
### UserService自己创建对象：
- 1、先在tsui.service中完成接口UserService和接口实现类UserServiceImpl
- 2、在tsui.test中，接口实例化对象指向接口实现类新创建的对象。
	``` java
	serService userService = new UserServiceImpl();
	```
- 3、测试一下userService对象是否正常。
	``` java
	userService.setName("崔烁豪");
	userService.add();
	```
注意：接口实例化的多个对象每次都指向接口实现类新创建的对象，那么接口实例化的多个对象不是同一个对象。


### 通过spring容器获取对象：
- 1、先在tsui.service中完成接口UserService和接口实现类UserServiceImpl
- 2、beans.xml中，配置bean对象（在id中定义对象名，但是还没有创建对象）：
    ``` xml
	<bean id="userService" class="tsui.service.UserServiceImpl"></bean>
	```
- 3、依赖注入：在beans.xml中的bean中添加property。name表示要添加数据的属性值，value表示添加的内容。
  注意：需要在UserServiceImpl中声明name属性并完成set方法。没有set方法会报对象创建异常。
	``` xml
	<bean id="userService" class="tsui.service.UserServiceImpl">
		<property name="name" value="张依方（依赖注入）"></property>
	</bean>
	```
- 4、在tsui.test中，用ApplicationContext加载配置文件，spring容器中会创建对象userService
	``` java
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    ```
- 5、从spring容器获取userService对象，接口实例化对象并指向spring容器中的实现对象
    注意：//getBean中的值userService要与beans.xml中bean的id的值一致
          //接口实例化对象userServicedemo可以随意命名
	``` java
    UserService userServicedemo = (UserService)context.getBean("userService");
    ```
- 6、测试一下userService对象是否正常。
	``` java
    userServicedemo.add();
    ```
注意：接口实例化的多个对象指向同一个spring容器中取出来的对象，那么接口实例化的多个对象是同一个对象。


**项目推到GitHub:**
https://my.oschina.net/aibinxiao/blog/914726

**项目推到GitHub遇到问题、删除git remote：**
https://www.jianshu.com/p/3380ec281729
