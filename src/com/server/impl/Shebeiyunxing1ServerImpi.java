package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.Shebeiyunxing1Mapper;
import com.entity.Shebeiyunxing1;
import com.server.Shebeiyunxing1Server;
@Service
public class Shebeiyunxing1ServerImpi implements Shebeiyunxing1Server {
   @Resource
   private Shebeiyunxing1Mapper gdao;
	@Override
	public int add(Shebeiyunxing1 po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shebeiyunxing1 po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shebeiyunxing1> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shebeiyunxing1> getsyshebeiyunxing1(Map<String, Object> map) {
		return gdao.getsyshebeiyunxing1(map);
	}
	public List<Shebeiyunxing1> getsyshebeiyunxing2(Map<String, Object> map) {
		return gdao.getsyshebeiyunxing2(map);
	}
	public List<Shebeiyunxing1> getsyshebeiyunxing3(Map<String, Object> map) {
		return gdao.getsyshebeiyunxing3(map);
	}
	
	@Override
	public Shebeiyunxing1 quchongShebeiyunxing(Map<String, Object> account) {
		return gdao.quchongShebeiyunxing(account);
	}

	@Override
	public List<Shebeiyunxing1> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shebeiyunxing1> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shebeiyunxing1 getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

