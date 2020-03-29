package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.HetongshengchengMapper;
import com.entity.Hetongshengcheng;
import com.server.HetongshengchengServer;
@Service
public class HetongshengchengServerImpi implements HetongshengchengServer {
   @Resource
   private HetongshengchengMapper gdao;
	@Override
	public int add(Hetongshengcheng po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Hetongshengcheng po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Hetongshengcheng> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Hetongshengcheng> getsyhetongshengcheng1(Map<String, Object> map) {
		return gdao.getsyhetongshengcheng1(map);
	}
	public List<Hetongshengcheng> getsyhetongshengcheng2(Map<String, Object> map) {
		return gdao.getsyhetongshengcheng2(map);
	}
	public List<Hetongshengcheng> getsyhetongshengcheng3(Map<String, Object> map) {
		return gdao.getsyhetongshengcheng3(map);
	}
	
	@Override
	public Hetongshengcheng quchongHetongshengcheng(Map<String, Object> account) {
		return gdao.quchongHetongshengcheng(account);
	}

	@Override
	public List<Hetongshengcheng> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Hetongshengcheng> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Hetongshengcheng getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

