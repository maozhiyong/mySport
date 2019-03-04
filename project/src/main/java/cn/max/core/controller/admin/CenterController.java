package cn.max.core.controller.admin;

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
@RequestMapping(value = "/admin")
public class CenterController {

    //登入页面
    @RequestMapping(value = "/index.do")
    public String index() {

        return "index";
    }

    //main页面
    @RequestMapping(value = "/main.do")
    public String main() {

        return "main";
    }

    //top页面
    @RequestMapping(value = "/top.do")
    public String top() {

        return "top";
    }

    //main 中的left页面
    @RequestMapping(value = "/left.do")
    public String left() {

        return "left";
    }

    //main right页面
    @RequestMapping(value = "/right.do")
    public String right() {

        return "right";
    }
}
