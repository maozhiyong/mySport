package cn.max.core.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 后台管理
 * 测试
 * @author maxwell
 *
 */
@Controller
public class CenterController implements WebBindingInitializer{
    //每一个springMVC
    @RequestMapping(value = "/test/springmvc.do")
    public String test(String name, Date birthday) {

        System.out.println(name);
        System.out.println(birthday);
        return "";
    }


    @InitBinder //implements WebBindingInitializer 这里有这个实现函数  这个函数解决的是这个control的日期转换（局部方法）
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
