package com.itheima.service.impl;

import com.itheima.dao.LogDao;
import com.itheima.pojo.Log;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public List<Log> findLogAll() {
        List<String> liens = logDao.findLogAll();
        List<Log> logList = liens.stream().map(line -> {
            String[] split = line.split(",");
            return new Log(split[0], split[1], split[2], split[3], split[4], split[5], split[6]);
        }).toList();
        return logList;
    }
}
