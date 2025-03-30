package com.itheima.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.itheima.dao.LogDao;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LogDaoImpl implements LogDao {
    @Override
    public List<String> findLogAll() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("log.txt");
        return IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
    }
}
