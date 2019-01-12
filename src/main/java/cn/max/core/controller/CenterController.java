package cn.max.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;

/**
 * 后台管理
 * 测试
 * @author maxwell
 *
 */
@Controller
public class CenterController{
    //每一个springMVC
    @RequestMapping(value = "/test/springmvc.do")
    public String test(String name, Date birthday) {

        System.out.println(name);
        System.out.println(birthday);
        return "";
    }
}
