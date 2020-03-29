package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ChukushenqingMapper;
import com.entity.Chukushenqing;
import com.server.ChukushenqingServer;
@Service
public class ChukushenqingServerImpi implements ChukushenqingServer {
   @Resource
   private ChukushenqingMapper gdao;
	@Override
	public int add(Chukushenqing po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Chukushenqing po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Chukushenqing> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Chukushenqing> getsychukushenqing1(Map<String, Object> map) {
		return gdao.getsychukushenqing1(map);
	}
	public List<Chukushenqing> getsychukushenqing2(Map<String, Object> map) {
		return gdao.getsychukushenqing2(map);
	}
	public List<Chukushenqing> getsychukushenqing3(Map<String, Object> map) {
		return gdao.getsychukushenqing3(map);
	}
	
	@Override
	public Chukushenqing quchongChukushenqing(Map<String, Object> account) {
		return gdao.quchongChukushenqing(account);
	}

	@Override
	public List<Chukushenqing> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Chukushenqing> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Chukushenqing getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

