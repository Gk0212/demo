package com.itheima.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.itheima.dao.DeptDao;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DeptDaoImpl implements DeptDao {
    @Override
    public List<String> findAll() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("dept.txt");
        return IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
    }
}
