package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShengdiaobuMapper;
import com.entity.Shengdiaobu;
import com.server.ShengdiaobuServer;
@Service
public class ShengdiaobuServerImpi implements ShengdiaobuServer {
   @Resource
   private ShengdiaobuMapper gdao;
	@Override
	public int add(Shengdiaobu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shengdiaobu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shengdiaobu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shengdiaobu> getsyshengdiaobu1(Map<String, Object> map) {
		return gdao.getsyshengdiaobu1(map);
	}
	public List<Shengdiaobu> getsyshengdiaobu2(Map<String, Object> map) {
		return gdao.getsyshengdiaobu2(map);
	}
	public List<Shengdiaobu> getsyshengdiaobu3(Map<String, Object> map) {
		return gdao.getsyshengdiaobu3(map);
	}
	
	@Override
	public Shengdiaobu quchongShengdiaobu(Map<String, Object> account) {
		return gdao.quchongShengdiaobu(account);
	}

	@Override
	public List<Shengdiaobu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shengdiaobu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shengdiaobu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

