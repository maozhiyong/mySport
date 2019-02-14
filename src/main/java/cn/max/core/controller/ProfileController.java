package cn.max.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.max.common.encode.Md5Pwd;
import cn.max.common.web.ResponseUtils;
import cn.max.common.web.session.SessionProvider;
import cn.max.core.bean.country.City;
import cn.max.core.bean.country.Province;
import cn.max.core.bean.country.Town;
import cn.max.core.bean.user.Buyer;
import cn.max.core.query.country.CityQuery;
import cn.max.core.query.country.TownQuery;
import cn.max.core.service.country.CityService;
import cn.max.core.service.country.ProvinceService;
import cn.max.core.service.country.TownService;
import cn.max.core.service.user.BuyerService;
import cn.max.core.web.Constants;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.octo.captcha.service.image.ImageCaptchaService;

/**
 * 跳转登陆页面
 * 登陆
 * 个人资料
 * 收货地址
 * @author max
 *
 */
@Controller
public class ProfileController {
	
	@Autowired
	private SessionProvider sessionProvider;
	@Autowired
	private Md5Pwd md5Pwd;
	@Autowired
	private BuyerService buyerService;
	@Autowired
	private ImageCaptchaService imageCaptchaService;

	//GET
	@RequestMapping(value = "/shopping/login.shtml",method=RequestMethod.GET)
	public String toLogin(){
		return "buyer/login";
	}

	//POST
	/**
	 * 1:验证码是否为null
		2:验证码  是否正确
		3:用户是否为NUll
		4:密码是否为NUll
		5:用户是否正确
		6密码是否正确
		Md5  纯生Md5 
		放进Session   跳转ReturnUrl
	 * @param buyer
	 * @param captcha
	 * @param returnUrl
	 * @return
	 */
	@RequestMapping(value = "/shopping/login.shtml",method=RequestMethod.POST)
	public String login(Buyer buyer, String captcha, String returnUrl, ModelMap model, HttpServletRequest request) {

		//验证码是否为null
		if (StringUtils.isBlank(captcha)) {
			model.addAttribute("error", "请填写验证码");
			return "buyer/login";
		}

		//用户名是否为null
		if (null == buyer || StringUtils.isBlank(buyer.getUsername())) {
			model.addAttribute("error", "请输入用户名");
			return "buyer/login";
		}

		//密码是否为null
		if (StringUtils.isBlank(buyer.getPassword())) {
			model.addAttribute("error", "请输入密码");
			return "buyer/login";
		}

		// 验证码验证
		if (!imageCaptchaService.validateResponseForID(sessionProvider.getSessionId(request), captcha)) {
			model.addAttribute("error", "验证码输入错误");
			return "buyer/login";
		}

		//用户名验证
		Buyer buyerInfo = buyerService.getBuyerByKey(buyer.getUsername());
		if (null == buyerInfo) {
			model.addAttribute("error", "用户名输入错误");
			return "buyer/login";
		}

		// 密码验证
		if (!buyerInfo.getPassword().equals(md5Pwd.encode(buyer.getPassword()))) {
			model.addAttribute("error", "密码错误");
			return "buyer/login";
		}

		//把用户对象放在Session
		sessionProvider.setAttribute(request, Constants.BUYER_SESSION, buyerInfo);
		if (StringUtils.isNotBlank(returnUrl)) {
			return "redirect:" + returnUrl;
		} else {
			//个人中心
			return "redirect:/buyer/index.shtml";
		}
	}

	//个人中心
	@RequestMapping(value = "/buyer/index.shtml")
	public String index(){
		return "buyer/index";
	}

	//个人资料
	@RequestMapping(value = "/buyer/profile.shtml")
	public String profile(HttpServletRequest request, ModelMap model){
		//加载用户
		Buyer buyer = (Buyer) sessionProvider.getAttribute(request, Constants.BUYER_SESSION);
		Buyer b = buyerService.getBuyerByKey(buyer.getUsername());
		model.addAttribute("buyer", b);
		//省
		List<Province> provinces = provinceService.getProvinceList(null);
		model.addAttribute("provinces", provinces);
		//市 
		CityQuery cityQuery = new CityQuery();
		cityQuery.setProvince(b.getProvince());
		List<City> citys = cityService.getCityList(cityQuery);
		model.addAttribute("citys", citys);
		//县
		TownQuery townQuery = new TownQuery();
		townQuery.setCity(b.getCity());
		List<Town> towns = townService.getTownList(townQuery);
		model.addAttribute("towns", towns);
		
		return "buyer/profile";
	}

	//
	@RequestMapping(value = "/buyer/city.shtml")
	public void city(String code,HttpServletResponse response){
		CityQuery cityQuery = new CityQuery();
		cityQuery.setProvince(code);
		List<City> citys = cityService.getCityList(cityQuery);
		
		JSONObject jo = new JSONObject();
		jo.put("citys", citys);
		ResponseUtils.renderJson(response, jo.toString());
		
	}

	//收货地址
	@RequestMapping(value = "/buyer/deliver_address.shtml")
	public String address(){
		
		return "buyer/deliver_address";
	}
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private CityService cityService;
	@Autowired
	private TownService townService;
}
