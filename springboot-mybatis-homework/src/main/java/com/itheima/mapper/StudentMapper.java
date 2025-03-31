package com.itheima.mapper;

import com.itheima.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from student")
    public List<Student> findAll();

    @Insert("insert into student(name, no, gender, phone, id_card, degree, graduation_date, create_time, update_time)" +
            " values (#{name},#{no},#{gender},#{phone},#{idCard},#{degree},#{graduationDate},now(),now())")
    public void insert(Student student);

    //根据ID更新学生的学号、手机号、身份证号
    @Update("update student set no = #{no}, phone = #{phone}, id_card = #{idCard}, update_time = now() where id = #{id}")
    public void update(Student student);

    public void selectById(Integer id);

    public void deleteById(Integer id);
}
