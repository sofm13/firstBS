package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JishuxieyiMapper;
import com.entity.Jishuxieyi;
import com.server.JishuxieyiServer;
@Service
public class JishuxieyiServerImpi implements JishuxieyiServer {
   @Resource
   private JishuxieyiMapper gdao;
	@Override
	public int add(Jishuxieyi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jishuxieyi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jishuxieyi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jishuxieyi> getsyjishuxieyi1(Map<String, Object> map) {
		return gdao.getsyjishuxieyi1(map);
	}
	public List<Jishuxieyi> getsyjishuxieyi2(Map<String, Object> map) {
		return gdao.getsyjishuxieyi2(map);
	}
	public List<Jishuxieyi> getsyjishuxieyi3(Map<String, Object> map) {
		return gdao.getsyjishuxieyi3(map);
	}
	
	@Override
	public Jishuxieyi quchongJishuxieyi(Map<String, Object> account) {
		return gdao.quchongJishuxieyi(account);
	}

	@Override
	public List<Jishuxieyi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jishuxieyi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jishuxieyi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

