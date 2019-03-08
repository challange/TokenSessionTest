package com.example.jwt.Controller;

import com.example.jwt.utils.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Usage:
 * @Author: gjq
 * @Date: 2019/3/8 9:59 AM
 */
@RestController
public class JwtTestController {


    @PostMapping("jwt")
    public String jwtTest (HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        JwtUtil jwt =new JwtUtil();
        return jwt.getUserIdFromRequest(request);
    }

}
