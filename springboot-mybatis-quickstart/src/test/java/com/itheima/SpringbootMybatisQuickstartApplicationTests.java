package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest // SpringBoot 单元测试的注解 - 当前测试类中的测试方法运行时，会启动springboot项目 - IOC容器
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }


    @Test
    public void testDleteById(){
        Integer i = userMapper.deleteById(4);
        System.out.println("执行完毕，影响的记录数："+i);
    }

    @Test
    public void testInsert(){
        User user = new User(null, "admin", "123456", "管理员", 18);
        userMapper.insert(user);
    }

    @Test
    public void testUpdate(){
        User user = new User(4, "guanyu", "666888", "关羽", 32);
        userMapper.update(user);
    }

    @Test
    public void testFindByUsernameAndPassword(){
        User user = userMapper.findByUsernameAndPassword("zhouyu", "123456");
        System.out.println(user);
    }
}
