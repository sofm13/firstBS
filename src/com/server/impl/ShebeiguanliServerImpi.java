package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShebeiguanliMapper;
import com.entity.Shebeiguanli;
import com.server.ShebeiguanliServer;
@Service
public class ShebeiguanliServerImpi implements ShebeiguanliServer {
   @Resource
   private ShebeiguanliMapper gdao;
	@Override
	public int add(Shebeiguanli po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shebeiguanli po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shebeiguanli> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shebeiguanli> getsyshebeiguanli1(Map<String, Object> map) {
		return gdao.getsyshebeiguanli1(map);
	}
	public List<Shebeiguanli> getsyshebeiguanli2(Map<String, Object> map) {
		return gdao.getsyshebeiguanli2(map);
	}
	public List<Shebeiguanli> getsyshebeiguanli3(Map<String, Object> map) {
		return gdao.getsyshebeiguanli3(map);
	}
	
	@Override
	public Shebeiguanli quchongShebeiguanli(Map<String, Object> account) {
		return gdao.quchongShebeiguanli(account);
	}

	@Override
	public List<Shebeiguanli> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shebeiguanli> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shebeiguanli getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

