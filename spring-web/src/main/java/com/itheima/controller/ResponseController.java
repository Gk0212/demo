package com.itheima.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {

    /**
     *  方式一： 通过HttpServletResponse对象响应数据
     */
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        //1. 设置响应状态码
        response.setStatus(401);

        //2. 设置响应头
        response.setHeader("name", "itheima");

        //3. 设置响应体
        response.getWriter().write("<h1>hello response</h1>");
    }

    /**
     *  方式二： 通过ResponseEntity对象响应数据
     */

    @RequestMapping("/response2")
    public ResponseEntity<String> response2() {
        return ResponseEntity
                .status(401)    // 设置响应状态码
                .header("name", "javaweb-ai")   // 设置响应头
                .body("<h1>hello response2</h1>");  // 设置响应体
    }
}
