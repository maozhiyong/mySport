package cn.max.core.web;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//这个是全局方法
public class CustomDateEdtor implements WebBindingInitializer{

    @Override
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
