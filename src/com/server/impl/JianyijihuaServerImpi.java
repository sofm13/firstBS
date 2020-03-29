package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JianyijihuaMapper;
import com.entity.Jianyijihua;
import com.server.JianyijihuaServer;
@Service
public class JianyijihuaServerImpi implements JianyijihuaServer {
   @Resource
   private JianyijihuaMapper gdao;
	@Override
	public int add(Jianyijihua po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jianyijihua po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jianyijihua> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jianyijihua> getsyjianyijihua1(Map<String, Object> map) {
		return gdao.getsyjianyijihua1(map);
	}
	public List<Jianyijihua> getsyjianyijihua2(Map<String, Object> map) {
		return gdao.getsyjianyijihua2(map);
	}
	public List<Jianyijihua> getsyjianyijihua3(Map<String, Object> map) {
		return gdao.getsyjianyijihua3(map);
	}
	
	@Override
	public Jianyijihua quchongJianyijihua(Map<String, Object> account) {
		return gdao.quchongJianyijihua(account);
	}

	@Override
	public List<Jianyijihua> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jianyijihua> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jianyijihua getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

