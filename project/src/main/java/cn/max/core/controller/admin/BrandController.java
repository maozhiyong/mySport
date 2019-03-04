package cn.max.core.controller.admin;

import cn.max.core.bean.PageBean;
import cn.max.core.bean.product.Brand;
import cn.max.core.service.product.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 品牌
 * @author max
 *
 */
@Controller
public class BrandController {

	
	@Autowired
	private BrandService brandService;
	
	//品牌列表页面
	@RequestMapping(value = "/brand/list.do")
	public String list(String name, Integer isDisplay, Integer pageNo, ModelMap model){
		
		//参数
		StringBuilder params = new StringBuilder();
		Brand brand = new Brand();

		//判断传进来的名称是否为Null并且还要判断 是否为空串   blank  ""  "   "   emtpy  ""   "  "
		if(StringUtils.isNotBlank(name)){
			brand.setName(name);
			params.append("name=").append(name);
		}

		//是  不是
		if(null != isDisplay){
			brand.setIsDisplay(isDisplay);
			params.append("&").append("isDisplay=").append(isDisplay);
		}else{
			brand.setIsDisplay(1);
			params.append("&").append("isDisplay=").append(1);
		}
		
		//如果页号为null 或小于1  置为1
		if (pageNo == null || pageNo < 1) {
			pageNo = 1;
		}

		brand.setPageNo(pageNo);

		//每页数
		brand.setPageSize(3);

		//分页对象
		PageBean brandListWithPage = brandService.getBrandListWithPage(brand);
		brandListWithPage.setCurrentPage(pageNo);

		String url = "/brand/list.do";
		brandListWithPage.pageView(url, params.toString());

		model.addAttribute("brandListWithPage", brandListWithPage);//request.setAttribute
		model.addAttribute("name", name);//request.setAttribute
		model.addAttribute("isDisplay", isDisplay);//request.setAttribute
		
		return "brand/list";
	}

	//跳转品牌添加页面
	@RequestMapping(value= "/brand/toAdd.do")
	public String toAdd(){
		return "brand/add";
	}

	//添加品牌
	@RequestMapping(value = "/brand/add.do")
	public String add(Brand brand){
		//添加开始
		brandService.addBrand(brand);
		return "redirect:/brand/list.do";
	}

	//删除一个品牌
	@RequestMapping(value = "/brand/delete.do")
	public String delete(Integer id,String name,Integer isDisplay,ModelMap model){
		//TODO 删除

		brandService.deleteBrandByKey(id);
		if(StringUtils.isNotBlank(name)){
			model.addAttribute("name", name);
		}
		if(null != isDisplay){
			model.addAttribute("isDisplay", isDisplay);
		}

		return "redirect:/brand/list.do";
	}

	//删除多个品牌
	@RequestMapping(value = "/brand/deletes.do")
	public String deletes(Integer[] ids,String name,Integer isDisplay,ModelMap model){
		//TODO 删除
		brandService.deleteBrandByKeys(ids);
		if(StringUtils.isNotBlank(name)){
			model.addAttribute("name", name);
		}
		if(null != isDisplay){
			model.addAttribute("isDisplay", isDisplay);
		}

		return "redirect:/brand/list.do";
	}

	//去修改页面
	@RequestMapping(value = "/brand/toEdit.do")
	public String toEdit(Integer id,ModelMap model){

		Brand brand = brandService.getBrandByKey(id);

		model.addAttribute("brand", brand);

		return "brand/edit";
	}

	//去修改页面
	@RequestMapping(value = "/brand/edit.do")
	public String edit(Brand brand,ModelMap model){

		brandService.updateBrandByKey(brand);

		return "redirect:/brand/list.do";
	}
}
