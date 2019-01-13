package cn.max.core.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    used for test
 */
@Controller
@RequestMapping("/")
public class EdgeController implements WebBindingInitializer {
    @RequestMapping("hello.shtml")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("hello");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().append("欢迎进入体育购物中心 前台页面");
    }

    //每一个springMVC
    @RequestMapping(value = "/test/springmvc.do")
    public String test(String name, Date birthday) {

        System.out.println(name);
        System.out.println(birthday);
        return "";
    }

    @InitBinder //implements WebBindingInitializer 这里有这个实现函数  这个函数解决的是这个control的日期转换（局部方法） 全局的在springmvc-back.xml中
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
