package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.WuzibuMapper;
import com.entity.Wuzibu;
import com.server.WuzibuServer;
@Service
public class WuzibuServerImpi implements WuzibuServer {
   @Resource
   private WuzibuMapper gdao;
	@Override
	public int add(Wuzibu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Wuzibu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Wuzibu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Wuzibu> getsywuzibu1(Map<String, Object> map) {
		return gdao.getsywuzibu1(map);
	}
	public List<Wuzibu> getsywuzibu2(Map<String, Object> map) {
		return gdao.getsywuzibu2(map);
	}
	public List<Wuzibu> getsywuzibu3(Map<String, Object> map) {
		return gdao.getsywuzibu3(map);
	}
	
	@Override
	public Wuzibu quchongWuzibu(Map<String, Object> account) {
		return gdao.quchongWuzibu(account);
	}

	@Override
	public List<Wuzibu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Wuzibu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Wuzibu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

