package cn.max.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/")
public class Control {
    @RequestMapping("index")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("hello");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().append("欢迎进入体育购物中心");
    }

    @RequestMapping(value = {" ","","/"}, method = RequestMethod.GET)
    public void defaultJump(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath()+"/index");
    }
}
