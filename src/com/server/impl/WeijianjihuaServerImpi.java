package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.WeijianjihuaMapper;
import com.entity.Weijianjihua;
import com.server.WeijianjihuaServer;
@Service
public class WeijianjihuaServerImpi implements WeijianjihuaServer {
   @Resource
   private WeijianjihuaMapper gdao;
	@Override
	public int add(Weijianjihua po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Weijianjihua po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Weijianjihua> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Weijianjihua> getsyweijianjihua1(Map<String, Object> map) {
		return gdao.getsyweijianjihua1(map);
	}
	public List<Weijianjihua> getsyweijianjihua2(Map<String, Object> map) {
		return gdao.getsyweijianjihua2(map);
	}
	public List<Weijianjihua> getsyweijianjihua3(Map<String, Object> map) {
		return gdao.getsyweijianjihua3(map);
	}
	
	@Override
	public Weijianjihua quchongWeijianjihua(Map<String, Object> account) {
		return gdao.quchongWeijianjihua(account);
	}

	@Override
	public List<Weijianjihua> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Weijianjihua> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Weijianjihua getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

