package com.example.session.controller;

import com.example.session.entity.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Usage:
 * @Author: gjq
 * @Date: 2019/3/7 5:13 PM
 */
@RestController
public class SessionTestController {
    /**
     * 集群测试分布式Session效果
     */

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write (HttpServletRequest request){
        HttpSession session = request.getSession();
        String value = String.valueOf("111");
        session.setAttribute("value", value);
        return value;
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String read (HttpServletRequest request){
        return String.valueOf(request.getSession().getAttribute("value"));
    }



    /**
     * 测试普通Session对象可直接修改，Redis中的Session对象需session.setAttribute更新
     */



    @RequestMapping(value = "/test_entity", method = RequestMethod.GET)
    public String test_entity (HttpServletRequest request){
        HttpSession session = request.getSession();
        Test test = new Test();
        test.setA("1234");
        test.setB("5678");
        session.setAttribute("test_entity", test);
        return String.valueOf(test.toString());
    }

    @RequestMapping(value = "/test_entity1", method = RequestMethod.GET)
    public String test_entity1 (HttpServletRequest request){
        Test test = (Test) request.getSession().getAttribute("test_entity");
        test.setA("8888");
        test.setB("5678");
        return String.valueOf(test.toString());
    }

    @RequestMapping(value = "/get_test_entity", method = RequestMethod.GET)
    public String get (HttpServletRequest request) {
        Test test = (Test) request.getSession().getAttribute("test_entity");
        return String.valueOf(test.toString());
    }

}
