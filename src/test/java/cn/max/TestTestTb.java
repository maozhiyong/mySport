package cn.max;

import frame.SpringJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import cn.max.core.bean.TestTb;
import cn.max.core.service.TestTbService;

/**
 * 测试
 * @author maxwell
 *
 */

public class TestTestTb extends SpringJunitTest {

	@Autowired
	private TestTbService testTbService;
	@Test
	public void testAdd() {
		TestTb testTb = new TestTb();
		testTb.setName("金乐乐");
		
		testTbService.addTestTb(testTb);
	}
}
