package com.oracle.web.test;



import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.oracle.web.bean.Monster2;
import com.oracle.web.bean.PageBean;




@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class MVCTest {
	
	//注入一个Web
	@Autowired
	WebApplicationContext context;
	
	//模拟发送请求
	
	MockMvc mvc;
	
	@Before
	public void init(){
		
		
		mvc=MockMvcBuilders.webAppContextSetup(context).build();
	}

	
	@Test
	public void testMonster() throws Exception{
		
		MvcResult result= mvc.perform(MockMvcRequestBuilders.get("/monstershowPasgeMonster/2")).andReturn();
		
		MockHttpServletRequest request = result.getRequest();
		
		
		PageBean<Monster2> pb = (PageBean<Monster2>) request.getAttribute("pb");
		
		System.out.println(pb);
		
		List<Monster2> list = pb.getBeanList();
		
		for (Monster2 monster2 : list) {
			
			System.out.println(monster2);
		}
	}
}
