package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.WeixiubaogaoMapper;
import com.entity.Weixiubaogao;
import com.server.WeixiubaogaoServer;
@Service
public class WeixiubaogaoServerImpi implements WeixiubaogaoServer {
   @Resource
   private WeixiubaogaoMapper gdao;
	@Override
	public int add(Weixiubaogao po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Weixiubaogao po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Weixiubaogao> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Weixiubaogao> getsyweixiubaogao1(Map<String, Object> map) {
		return gdao.getsyweixiubaogao1(map);
	}
	public List<Weixiubaogao> getsyweixiubaogao2(Map<String, Object> map) {
		return gdao.getsyweixiubaogao2(map);
	}
	public List<Weixiubaogao> getsyweixiubaogao3(Map<String, Object> map) {
		return gdao.getsyweixiubaogao3(map);
	}
	
	@Override
	public Weixiubaogao quchongWeixiubaogao(Map<String, Object> account) {
		return gdao.quchongWeixiubaogao(account);
	}

	@Override
	public List<Weixiubaogao> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Weixiubaogao> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Weixiubaogao getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

