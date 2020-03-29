package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShebeishenqingMapper;
import com.entity.Shebeishenqing;
import com.server.ShebeishenqingServer;
@Service
public class ShebeishenqingServerImpi implements ShebeishenqingServer {
   @Resource
   private ShebeishenqingMapper gdao;
	@Override
	public int add(Shebeishenqing po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shebeishenqing po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shebeishenqing> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shebeishenqing> getsyshebeishenqing1(Map<String, Object> map) {
		return gdao.getsyshebeishenqing1(map);
	}
	public List<Shebeishenqing> getsyshebeishenqing2(Map<String, Object> map) {
		return gdao.getsyshebeishenqing2(map);
	}
	public List<Shebeishenqing> getsyshebeishenqing3(Map<String, Object> map) {
		return gdao.getsyshebeishenqing3(map);
	}
	
	@Override
	public Shebeishenqing quchongShebeishenqing(Map<String, Object> account) {
		return gdao.quchongShebeishenqing(account);
	}

	@Override
	public List<Shebeishenqing> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shebeishenqing> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shebeishenqing getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

