package cn.max.core.controller.uploadServer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//模拟的是上传服务器 假的
@Controller
public class UploadServerController {

	@RequestMapping(value = {"/admin/*.png"},method = RequestMethod.PUT)
	public void putToServer(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("put");
		response.setStatus(200);
	}

	@RequestMapping(value = {"/admin/*.png"},method = RequestMethod.POST)
	public void postToServer(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("post");
		response.setStatus(200);
	}

	@RequestMapping(value = {"/admin/*.png"},method = RequestMethod.GET)
	public void getFromServer(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("get");
	}
}
