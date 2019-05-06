package com.oracle.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.ssh.service.MonsterService;
import com.oracle.web.bean.Monster;
import com.oracle.web.bean.Monster2;
import com.oracle.web.bean.PageBean;
import com.oracle.web.mapper.MonsterMapper;

@Service
public class MonsterServiceImpl implements MonsterService {

	@Autowired
	private MonsterMapper monsterMapper;

	@Override
	@Transactional(readOnly=true)
	public List<Monster> list() {
		// TODO Auto-generated method stub
		return this.monsterMapper.selectAll();
	}

	@Override
	@Transactional
	public int save(Monster monster) {
		// TODO Auto-generated method stub
		return this.monsterMapper.insert(monster);
	}

	@Override
	@Transactional
	public void delete(Monster monster) {
		// TODO Auto-generated method stub
		this.monsterMapper.deleteByPrimaryKey(monster.getMonsterId());
	}

	@Override
	@Transactional
	public Monster  showOne(Integer integer) {
		// TODO Auto-generated method stub
		return this.monsterMapper.selectByPrimaryKey(integer);
	}

	@Override
	@Transactional
	public void update(Monster monster) {
		// TODO Auto-generated method stub
		this.monsterMapper.updateByPrimaryKey(monster);
	}

 
 	@Override
	@Transactional
	public List<Monster2> showPesgefl(int pageNow) {
		// TODO Auto-generated method stub
		return this.monsterMapper.showPesgefl(pageNow);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return this.monsterMapper.count();
	}

	@Override
	public PageBean<Monster2> selectAllByPageHelper(Integer pageNow) {
		// TODO Auto-generated method stub
		PageBean<Monster2> pb=new PageBean<Monster2>();
		
		//用pageHelper完成分页
		
		PageHelper.startPage(pageNow, 3);
		
		List<Monster2> list = this.monsterMapper.selectAllByPageHelper();
		
		PageInfo<Monster2> pi=new PageInfo<Monster2>(list);
		
		pb.setBeanList(list);
		
		pb.setCounts((int)pi.getTotal());
		
		pb.setpageNow(pageNow);
		
		pb.setPageSize(3);
		
		return pb;
	}
 

 
}
