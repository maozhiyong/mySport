package cn.max;

import java.io.StringWriter;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Test;

import cn.max.core.bean.user.Buyer;

/**
 * 购物车对象 转成JSON
 * @author lx
 *
 */
public class TestJSON {

	@Test
	public void testJson() throws Exception {
		
		Buyer buyer = new Buyer();
		buyer.setUsername("fbb2014");
		
		//springmvc 
		ObjectMapper  om = new ObjectMapper();
		om.setSerializationInclusion(Inclusion.NON_NULL);
		
		//流
		StringWriter str = new StringWriter(); 
		
		//对象转Json  写的过程     Json是字符串流
		om.writeValue(str, buyer);
		
		System.out.println(str.toString());
		
		//JSON 转对象
		Buyer b = om.readValue(str.toString(), Buyer.class);
		
		System.out.println(b);
		
		
	}
}
