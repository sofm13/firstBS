package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShebeirukuMapper;
import com.entity.Shebeiruku;
import com.server.ShebeirukuServer;
@Service
public class ShebeirukuServerImpi implements ShebeirukuServer {
   @Resource
   private ShebeirukuMapper gdao;
	@Override
	public int add(Shebeiruku po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shebeiruku po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shebeiruku> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shebeiruku> getsyshebeiruku1(Map<String, Object> map) {
		return gdao.getsyshebeiruku1(map);
	}
	public List<Shebeiruku> getsyshebeiruku2(Map<String, Object> map) {
		return gdao.getsyshebeiruku2(map);
	}
	public List<Shebeiruku> getsyshebeiruku3(Map<String, Object> map) {
		return gdao.getsyshebeiruku3(map);
	}
	
	@Override
	public Shebeiruku quchongShebeiruku(Map<String, Object> account) {
		return gdao.quchongShebeiruku(account);
	}

	@Override
	public List<Shebeiruku> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shebeiruku> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shebeiruku getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

