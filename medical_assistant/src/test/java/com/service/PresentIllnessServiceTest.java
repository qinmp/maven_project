package com.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.util.vo.ServiceResult;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PresentIllnessServiceTest {
//	@Autowired
	private PresentIllnessService presentIllnessService;
	
//	@Test
	public void getPresentIllnessTest(){
		try {
			ServiceResult result = new  ServiceResult(false, "获取失败");
			presentIllnessService.getPresentIllness("20170626226", result, 6L);
			System.out.println(result.toJSON());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
