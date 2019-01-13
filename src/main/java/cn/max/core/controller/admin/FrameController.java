package cn.max.core.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 模块身体加载（框架控制）
 * @author maxwell
 *
 */
@Controller
@RequestMapping(value = "/admin")
public class FrameController {

    //商品身体
    @RequestMapping(value = "/frame/product_main.do")
    public String productMain() {

        return "frame/product_main";
    }

    //商品左
    @RequestMapping(value = "/frame/product_left.do")
    public String productMainLeft() {

        return "frame/product_left";
    }

    //订单身体
    @RequestMapping(value = "/frame/order_main.do")
    public String orderMain() {

        return "frame/order_main";
    }

    //订单左
    @RequestMapping(value = "/frame/order_left.do")
    public String orderMainLeft() {

        return "frame/order_left";
    }

}
