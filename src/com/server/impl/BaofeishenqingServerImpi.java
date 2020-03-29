package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BaofeishenqingMapper;
import com.entity.Baofeishenqing;
import com.server.BaofeishenqingServer;
@Service
public class BaofeishenqingServerImpi implements BaofeishenqingServer {
   @Resource
   private BaofeishenqingMapper gdao;
	@Override
	public int add(Baofeishenqing po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Baofeishenqing po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Baofeishenqing> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Baofeishenqing> getsybaofeishenqing1(Map<String, Object> map) {
		return gdao.getsybaofeishenqing1(map);
	}
	public List<Baofeishenqing> getsybaofeishenqing2(Map<String, Object> map) {
		return gdao.getsybaofeishenqing2(map);
	}
	public List<Baofeishenqing> getsybaofeishenqing3(Map<String, Object> map) {
		return gdao.getsybaofeishenqing3(map);
	}
	
	@Override
	public Baofeishenqing quchongBaofeishenqing(Map<String, Object> account) {
		return gdao.quchongBaofeishenqing(account);
	}

	@Override
	public List<Baofeishenqing> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Baofeishenqing> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Baofeishenqing getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

