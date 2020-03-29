package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShebeiyunxingMapper;
import com.entity.Shebeiyunxing;
import com.server.ShebeiyunxingServer;
@Service
public class ShebeiyunxingServerImpi implements ShebeiyunxingServer {
   @Resource
   private ShebeiyunxingMapper gdao;
	@Override
	public int add(Shebeiyunxing po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shebeiyunxing po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shebeiyunxing> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shebeiyunxing> getsyshebeiyunxing1(Map<String, Object> map) {
		return gdao.getsyshebeiyunxing1(map);
	}
	public List<Shebeiyunxing> getsyshebeiyunxing2(Map<String, Object> map) {
		return gdao.getsyshebeiyunxing2(map);
	}
	public List<Shebeiyunxing> getsyshebeiyunxing3(Map<String, Object> map) {
		return gdao.getsyshebeiyunxing3(map);
	}
	
	@Override
	public Shebeiyunxing quchongShebeiyunxing(Map<String, Object> account) {
		return gdao.quchongShebeiyunxing(account);
	}

	@Override
	public List<Shebeiyunxing> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shebeiyunxing> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shebeiyunxing getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

