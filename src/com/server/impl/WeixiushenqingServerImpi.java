package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.WeixiushenqingMapper;
import com.entity.Weixiushenqing;
import com.server.WeixiushenqingServer;
@Service
public class WeixiushenqingServerImpi implements WeixiushenqingServer {
   @Resource
   private WeixiushenqingMapper gdao;
	@Override
	public int add(Weixiushenqing po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Weixiushenqing po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Weixiushenqing> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Weixiushenqing> getsyweixiushenqing1(Map<String, Object> map) {
		return gdao.getsyweixiushenqing1(map);
	}
	public List<Weixiushenqing> getsyweixiushenqing2(Map<String, Object> map) {
		return gdao.getsyweixiushenqing2(map);
	}
	public List<Weixiushenqing> getsyweixiushenqing3(Map<String, Object> map) {
		return gdao.getsyweixiushenqing3(map);
	}
	
	@Override
	public Weixiushenqing quchongWeixiushenqing(Map<String, Object> account) {
		return gdao.quchongWeixiushenqing(account);
	}

	@Override
	public List<Weixiushenqing> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Weixiushenqing> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Weixiushenqing getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

