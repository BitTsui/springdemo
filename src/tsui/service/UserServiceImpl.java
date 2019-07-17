package tsui.service;

public class UserServiceImpl implements UserService{

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add() {
        System.out.println("创建用户...." + name);
    }
}
