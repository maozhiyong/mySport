package cn.max.core.web;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//这个是全局方法 //WebBindingInitializer 这个如果用在将control实现，或者对应方法加上@InitBinder，也可以弄成单独的control的局部解析时间，
public class CustomDateEdtor implements WebBindingInitializer{

    @Override
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
