package com.oracle.web.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.oracle.web.bean.Monster2;
import com.oracle.web.mapper.MonsterMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {

	//注入mapper
	@Autowired
	private MonsterMapper monsterMapper;
	
	@Test
	public void testSelectAll(){
		
		PageHelper.startPage(2, 2);
		
		List<Monster2> list = this.monsterMapper.selectAllByPageHelper();
		
		for (Monster2 subMonster : list) {
			
			System.out.println(subMonster);
		}
	}
}
