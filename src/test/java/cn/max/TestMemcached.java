package cn.max;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import cn.max.core.bean.user.Buyer;
import frame.SpringJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.danga.MemCached.MemCachedClient;

/**
 * 测试
 * @author max
 *
 */

public class TestMemcached extends SpringJunitTest {

	@Autowired
	private MemCachedClient memCachedClient;
	@Test
	public void testAdd() throws Exception {
		memCachedClient.set("a", "input");
		String data = (String)memCachedClient.get("a");
		System.out.printf(data);
//		Buyer buyer = new Buyer();
//		buyer.setUsername("范冰冰");
//
//
//		//memCachedClient.set("fbb2",buyer);
//
//		Map<String, Object> keySet = MemCachedUtil.getKeySet(memCachedClient);
//
//
//		Set<Entry<String, Object>> entrySet = keySet.entrySet();
//		for(Entry<String, Object> entry : entrySet){
//			System.out.println(entry.getKey());
//		}
		
		
/*		Object object = memCachedClient.get("fbb");
		
		System.out.println(object);*/
	}
}
