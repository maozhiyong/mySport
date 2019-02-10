package cn.max.core.controller.admin;


import cn.max.core.bean.PageBean;
import cn.max.core.bean.product.Brand;
import cn.max.core.query.product.BrandQuery;
import cn.max.core.query.product.ProductQuery;
import cn.max.core.service.product.BrandService;
import cn.max.core.service.product.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * 后台商品管理
 * 商品列表
 * 商品添加'
 * 商品上架
 * @author maxwell
 *
 */
@Controller
public class ProductController {
	
	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;

	//商品列表
	@RequestMapping(value = "/product/list.do")
	public String list(Integer pageNo,String name,Integer brandId,Integer isShow,ModelMap model){
		
		BrandQuery brandQuery = new BrandQuery();
		
		brandQuery.setFields("id,name");
		brandQuery.setIsDisplay(1);
		//加载品牌
		List<Brand> brands = brandService.getBrandList(brandQuery);
		
		model.addAttribute("brands", brands);
		
		
		//分页参数
		StringBuilder params = new StringBuilder();
		
		//商品条件对象
		ProductQuery productQuery = new ProductQuery();
		//1:判断条件是为Null
		if(StringUtils.isNotBlank(name)){
			productQuery.setName(name);
			//要求模糊查询
			productQuery.setNameLike(true);
			
			params.append("&name=").append(name);
			
			//回显查询条件
			model.addAttribute("name", name);
		}
		//判断品牌ID
		if(null != brandId){
			productQuery.setBrandId(brandId);
			params.append("&").append("brandId=").append(brandId);
			
			//回显查询条件
			model.addAttribute("brandId", brandId);
		}
		//判断上下架状态
		if(null != isShow){
			productQuery.setIsShow(isShow);
			params.append("&").append("isShow=").append(isShow);
			
			//回显查询条件
			model.addAttribute("isShow", isShow);
		}else{
			productQuery.setIsShow(0);
			params.append("&").append("isShow=").append(0);
			//回显查询条件
			model.addAttribute("isShow", 0);
		}
		//设置页号
		productQuery.setPageNo(PageBean.calculateCurrentPageNum(pageNo));
		//设置每页数
		productQuery.setPageSize(5);
		
		//加载带有分页的商品
		PageBean productListWithPage = productService.getProductListWithPage(productQuery);

		//分页页面展示
		String url = "/product/list.do";
		productListWithPage.pageView(url, params.toString());
		
		model.addAttribute("pagination", productListWithPage);
		
		return "product/list";
	}
}
