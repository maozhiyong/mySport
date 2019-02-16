package cn.max.core.controller;

import java.io.StringWriter;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.max.core.bean.BuyCart;
import cn.max.core.bean.BuyItem;
import cn.max.core.bean.product.Sku;
import cn.max.core.service.product.SkuService;
import cn.max.core.web.Constants;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 购物车
 * @author max
 *
 */
@Controller
public class CartController {

	//购买按钮
	@RequestMapping(value = "/shopping/buyCart.shtml")
	public String buyCart(Integer skuId, Integer amount, Integer buyLimit, Integer productId, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		//第一步:Sku
			//springmvc 
			ObjectMapper  om = new ObjectMapper();
			om.setSerializationInclusion(Inclusion.NON_NULL);
			
			//声明
			BuyCart buyCart = null;
			//判断Cookie是否有购物车  
			
			//JESSIONID
			//buyCart_cookie
			//  
			Cookie[] cookies = request.getCookies();
			if(null != cookies && cookies.length >0){
				for(Cookie c : cookies){
					if(Constants.BUYCART_COOKIE.equals(c.getName())){
						//如果有了  就使用此购物车
						String value = c.getValue();//
						//
						try {
							buyCart = om.readValue(value, BuyCart.class);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
				}
			}
			//如果有了  就使用此购物车
			//如果没有 创建购物车
			
			if(null == buyCart){
				//购物车   //最后一款
				buyCart = new BuyCart();
			}
			//
		if(null != skuId){
			Sku sku = new Sku();
			sku.setId(skuId);
			//限制
			if(null != buyLimit){
				sku.setSkuUpperLimit(buyLimit);
			}
			//创建购物项
			BuyItem buyItem = new BuyItem();
			
			buyItem.setSku(sku);
			//数量  1 2 3  -1
			buyItem.setAmount(amount);
			//添加购物项
			buyCart.addItem(buyItem);
			//最后一款商品的ID
			if(null != productId){
				buyCart.setProductId(productId);
			}
			
			//流
			StringWriter str = new StringWriter(); 
			//对象转Json  写的过程     Json是字符串流
			try {
				om.writeValue(str, buyCart);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//购物车装进Cookie中   对象转Json
			Cookie cookie = new Cookie(Constants.BUYCART_COOKIE,str.toString());
			//关闭浏览器 也要有Cookie
			//默认是 -1  关闭浏览器 就没了
			//消灭  0  马上就没有
			//expiry 秒
			cookie.setMaxAge(60*60*24);
			//路径
			///shopping/buyCart.shtml
			//默认  /shopping
			//  /shopping
			// /buyer/*.shtml
			cookie.setPath("/");
			//发送
			response.addCookie(cookie);
		}
		//装购物车装满
		List<BuyItem> items = buyCart.getItems();
		for(BuyItem item : items){
			Sku s = skuService.getSkuByKey(item.getSku().getId());
			item.setSku(s);
			//小计
		}
		//小计
		
		model.addAttribute("buyCart", buyCart);
		
		return "product/cart";
	}
	//清空购物车
	@RequestMapping(value = "/shopping/clearCart.shtml")
	public String clearCart(HttpServletRequest request,HttpServletResponse response){

		Cookie cookie = new Cookie(Constants.BUYCART_COOKIE,null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);

		
		return "redirect:/shopping/buyCart.shtml";
	}
	//删除一个购物项
	@RequestMapping(value = "/shopping/deleteItem.shtml")
	public String deleteItem(HttpServletRequest request,Integer skuId,HttpServletResponse response){
		//springmvc 
		ObjectMapper  om = new ObjectMapper();
		om.setSerializationInclusion(Inclusion.NON_NULL);
		
		//声明
		BuyCart buyCart = null;
		//判断Cookie是否有购物车  
		
		//JESSIONID
		//buyCart_cookie
		//  
		Cookie[] cookies = request.getCookies();
		if(null != cookies && cookies.length >0){
			for(Cookie c : cookies){
				if(Constants.BUYCART_COOKIE.equals(c.getName())){
					//如果有了  就使用此购物车
					String value = c.getValue();//
					//
					try {
						buyCart = om.readValue(value, BuyCart.class);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
		}
		if(null != buyCart){
			Sku sku = new Sku();
			sku.setId(skuId);
			//创建购物项
			BuyItem buyItem = new BuyItem();
			buyItem.setSku(sku);
			
			buyCart.deleteItem(buyItem);
			
			//流
			StringWriter str = new StringWriter(); 
			//对象转Json  写的过程     Json是字符串流
			try {
				om.writeValue(str, buyCart);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//购物车装进Cookie中   对象转Json
			Cookie cookie = new Cookie(Constants.BUYCART_COOKIE,str.toString());
			//关闭浏览器 也要有Cookie
			//默认是 -1  关闭浏览器 就没了
			//消灭  0  马上就没有
			//expiry 秒
			cookie.setMaxAge(60*60*24);
			//路径
			///shopping/buyCart.shtml
			//默认  /shopping
			//  /shopping
			// /buyer/*.shtml
			cookie.setPath("/");
			//发送
			response.addCookie(cookie);

		}
		return "redirect:/shopping/buyCart.shtml";
	}
	@Autowired
	private SkuService skuService;
}
