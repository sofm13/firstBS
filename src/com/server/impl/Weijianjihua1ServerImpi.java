package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.Weijianjihua1Mapper;
import com.entity.Weijianjihua1;
import com.server.Weijianjihua1Server;
@Service
public class Weijianjihua1ServerImpi implements Weijianjihua1Server {
   @Resource
   private Weijianjihua1Mapper gdao;
	@Override
	public int add(Weijianjihua1 po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Weijianjihua1 po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Weijianjihua1> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Weijianjihua1> getsyweijianjihua1(Map<String, Object> map) {
		return gdao.getsyweijianjihua1(map);
	}
	public List<Weijianjihua1> getsyweijianjihua2(Map<String, Object> map) {
		return gdao.getsyweijianjihua2(map);
	}
	public List<Weijianjihua1> getsyweijianjihua3(Map<String, Object> map) {
		return gdao.getsyweijianjihua3(map);
	}
	
	@Override
	public Weijianjihua1 quchongWeijianjihua(Map<String, Object> account) {
		return gdao.quchongWeijianjihua(account);
	}

	@Override
	public List<Weijianjihua1> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Weijianjihua1> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Weijianjihua1 getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

