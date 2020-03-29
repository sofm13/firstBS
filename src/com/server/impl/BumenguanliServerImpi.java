package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BumenguanliMapper;
import com.entity.Bumenguanli;
import com.server.BumenguanliServer;
@Service
public class BumenguanliServerImpi implements BumenguanliServer {
   @Resource
   private BumenguanliMapper gdao;
	@Override
	public int add(Bumenguanli po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Bumenguanli po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Bumenguanli> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Bumenguanli> getsybumenguanli1(Map<String, Object> map) {
		return gdao.getsybumenguanli1(map);
	}
	public List<Bumenguanli> getsybumenguanli2(Map<String, Object> map) {
		return gdao.getsybumenguanli2(map);
	}
	public List<Bumenguanli> getsybumenguanli3(Map<String, Object> map) {
		return gdao.getsybumenguanli3(map);
	}
	
	@Override
	public Bumenguanli quchongBumenguanli(Map<String, Object> account) {
		return gdao.quchongBumenguanli(account);
	}

	@Override
	public List<Bumenguanli> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Bumenguanli> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Bumenguanli getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

