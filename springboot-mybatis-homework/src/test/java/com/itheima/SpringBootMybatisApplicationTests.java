package com.itheima;

import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class SpringBootMybatisApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testfindAll() {
        List<Student> studentList = studentMapper.findAll();
        studentList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        LocalDate manualDate = LocalDate.of(2019, 11, 11);
        Student student = new Student(null, "小红", "2019011", 1, "13800000011", "111111111111111121", 1, manualDate, LocalDateTime.now(), LocalDateTime.now());
        studentMapper.insert(student);
    }

    @Test
    public void testUpdate() {
        Student student = new Student(11, "2019022", "13800000022", "111111111111111141");
        studentMapper.update(student);
    }

    @Test
    public void testSelectById() {
        studentMapper.selectById(11);
    }

    @Test
    public void testDeleteById() {
        studentMapper.deleteById(11);
    }

}
