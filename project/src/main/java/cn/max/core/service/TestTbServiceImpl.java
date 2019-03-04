package cn.max.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.max.core.bean.TestTb;
import cn.max.core.dao.TestTbDao;

/**
 * 
 * @author maxwell
 *
 */
@Service
//@Transactional
public class TestTbServiceImpl implements TestTbService{

	@Resource
	private TestTbDao testTbDao;
	
	public void addTestTb(TestTb testTb) {
		testTbDao.addTestTb(testTb);
		
//		throw new RuntimeException();
	}

}
