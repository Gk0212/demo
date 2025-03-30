package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper // 应用程序在运行时，会自动的为该接口创建一个实现类对象（代理对象），并且会自动将该对象添加到（IOC容器）spring容器中 -bean
public interface UserMapper {

    //@Select("select id, username, password, name, age from user")
    public List<User> findAll();


    // 根据id删除用户信息
    @Delete("delete from user where id = #{id}")
    // public void deleteById(Integer id);
    public Integer deleteById(Integer id);

    // 新增用户
    @Insert("insert into user(username, password, name, age) values (#{username}, #{password}, #{name}, #{age})")
    public void insert(User user);

    // 修改用户信息
    @Update("update user set username = #{username}, password = #{password}, name = #{name}, age = #{age} where id = #{id}")
    public void update(User user);

    // 根据用户名和密码查询用户信息
    @Select("select * from user where username = #{username} and password = #{password}")
    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
