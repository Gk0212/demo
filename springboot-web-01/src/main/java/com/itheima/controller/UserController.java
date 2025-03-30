package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //@ResponseBody -> 作用：将controller返回值直接作为响应体的数据直接响应;返回值是对象/集合->json->响应
public class UserController {

    // 方式一： 属性注入
    // 优点： 简单，方便，易理解
    // 缺点： 隐藏了类之间的依赖关系， 可能会破坏类的封装性
    //    @Autowired
    //    @Qualifier("userServiceImpl")
    //    private UserService userService;
    @Resource(name = "userServiceImpl2")
    private UserService userService;

    // 方式二： 构造器注入
    // 优点： 能清晰地看到类的依赖关系、提高了代码的安全性
    // 缺点： 代码繁琐、如果构造参数过多，可能会导致构造函数臃肿
    //    private final UserService userService;
    //    @Autowired  // 如果当前类中有且仅有一个有参构造器，则@Autowired可以省略
    //    public UserController(UserService userService) {
    //        this.userService = userService;
    //    }

    // 方式三： setter 注入
    // 优点： 保持了类的封装性，依赖关系更清晰
    // 缺点： 需要额外编写setter方法，增加了代码量
    //    private UserService userService;
    //    @Autowired
    //    public void setUserService(UserService userService) {
    //        this.userService = userService;
    //    }

    @RequestMapping("list")
    public List<User> list() throws Exception {
        /*        //1. 加载并读取user.txt 文件，获取用户数据
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines= IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());

        //2. 解析用户信息，封装为 User 对象 -> list 集合
        List<User> userList = lines.stream().map( line -> {
            String[] split = line.split(",");
            Integer id = Integer.parseInt(split[0]);
            String username = split[1];
            String password = split[2];
            String name = split[3];
            Integer age = Integer.parseInt(split[4]);
            LocalDateTime  updateTime = LocalDateTime.parse(split[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).toList();

        //3. 返回数据（json）
        return userList;*/

        //1. 调用service，获取数据
        List<User> userList = userService.findAll();

        //2. 返回数据（json）
        return userList;
    }
}
