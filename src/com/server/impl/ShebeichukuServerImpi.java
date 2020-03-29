package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShebeichukuMapper;
import com.entity.Shebeichuku;
import com.server.ShebeichukuServer;
@Service
public class ShebeichukuServerImpi implements ShebeichukuServer {
   @Resource
   private ShebeichukuMapper gdao;
	@Override
	public int add(Shebeichuku po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shebeichuku po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shebeichuku> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shebeichuku> getsyshebeichuku1(Map<String, Object> map) {
		return gdao.getsyshebeichuku1(map);
	}
	public List<Shebeichuku> getsyshebeichuku2(Map<String, Object> map) {
		return gdao.getsyshebeichuku2(map);
	}
	public List<Shebeichuku> getsyshebeichuku3(Map<String, Object> map) {
		return gdao.getsyshebeichuku3(map);
	}
	
	@Override
	public Shebeichuku quchongShebeichuku(Map<String, Object> account) {
		return gdao.quchongShebeichuku(account);
	}

	@Override
	public List<Shebeichuku> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shebeichuku> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shebeichuku getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

