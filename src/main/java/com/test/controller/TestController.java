package com.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.entity.User;
import com.test.util.MyFreemarkerUtil;

@Controller
public class TestController {

    @Autowired
    MyFreemarkerUtil myFreemarkerUtil;

    @RequestMapping("test")
    public void test(HttpServletResponse response) throws Exception {
        response.setContentType("text/html; charset=utf-8");

        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "a"));
        userList.add(new User(2, "b"));

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "helloworld");
        map.put("userList", userList);

        myFreemarkerUtil.write("index.html", map, response.getWriter());
    }

}
