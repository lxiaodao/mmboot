package com.itheima.web.controller;

import com.alibaba.fastjson.JSON;

import com.itheima.service.front.MemberService;

import com.itheima.service.front.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseController {
   
    protected <T> T getData(HttpServletRequest request, Class<T> clazz) throws IOException {
        //1.收集数据（request数据）
        String json = JSON.parseObject(request.getInputStream(), String.class);
        //2.组织成一个实体类（Member)
        return JSON.parseObject(json, clazz);
    }


    protected void returnData(HttpServletResponse response,Result result) throws IOException {
        //5.返回结果(json数据解析）
        response.setContentType("application/json;charset=utf-8");
        JSON.writeJSONString(response.getOutputStream(),result);

    }

   
}
