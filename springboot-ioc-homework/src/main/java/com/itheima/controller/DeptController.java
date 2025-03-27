package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/depts")
    public List<Dept> list() throws Exception {
        List<Dept> deptList = deptService.findAllDept();
        return deptList;
    }

}
