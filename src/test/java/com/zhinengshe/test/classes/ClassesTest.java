package com.zhinengshe.test.classes;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhinengshe.pojo.classes.Classes;
import com.zhinengshe.service.classes.IClassesService;
import com.zhinengshe.test.basetest.BaseTest;

public class ClassesTest extends BaseTest {

	@Autowired
	private IClassesService service;
	
	@Test
	public void testGet() throws Exception{
		
		Classes c = new Classes();
		c.setCourse("12");
		c.setEndtime(new Date());
		c.setName("sfsfsdf");
		c.setStarttime(new Date());
		c.setState(new Byte("1"));
		c.setTotalcount(23);
		
		
		
		
		Boolean b= this.service.add(c);
		
		System.out.println(b);
		
	}
	
}
