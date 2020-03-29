package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.FapiaoguanliMapper;
import com.entity.Fapiaoguanli;
import com.server.FapiaoguanliServer;
@Service
public class FapiaoguanliServerImpi implements FapiaoguanliServer {
   @Resource
   private FapiaoguanliMapper gdao;
	@Override
	public int add(Fapiaoguanli po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Fapiaoguanli po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Fapiaoguanli> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Fapiaoguanli> getsyfapiaoguanli1(Map<String, Object> map) {
		return gdao.getsyfapiaoguanli1(map);
	}
	public List<Fapiaoguanli> getsyfapiaoguanli2(Map<String, Object> map) {
		return gdao.getsyfapiaoguanli2(map);
	}
	public List<Fapiaoguanli> getsyfapiaoguanli3(Map<String, Object> map) {
		return gdao.getsyfapiaoguanli3(map);
	}
	
	@Override
	public Fapiaoguanli quchongFapiaoguanli(Map<String, Object> account) {
		return gdao.quchongFapiaoguanli(account);
	}

	@Override
	public List<Fapiaoguanli> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Fapiaoguanli> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Fapiaoguanli getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

