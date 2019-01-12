package cn.max.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class EdgeController {
    @RequestMapping("hello.shtml")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("hello");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().append("欢迎进入体育购物中心 前台页面");
    }
}
