package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.Shebeiyunxing2Mapper;
import com.entity.Shebeiyunxing2;
import com.server.Shebeiyunxing2Server;
@Service
public class Shebeiyunxing2ServerImpi implements Shebeiyunxing2Server {
   @Resource
   private Shebeiyunxing2Mapper gdao;
	@Override
	public int add(Shebeiyunxing2 po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shebeiyunxing2 po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shebeiyunxing2> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shebeiyunxing2> getsyshebeiyunxing1(Map<String, Object> map) {
		return gdao.getsyshebeiyunxing1(map);
	}
	public List<Shebeiyunxing2> getsyshebeiyunxing2(Map<String, Object> map) {
		return gdao.getsyshebeiyunxing2(map);
	}
	public List<Shebeiyunxing2> getsyshebeiyunxing3(Map<String, Object> map) {
		return gdao.getsyshebeiyunxing3(map);
	}
	
	@Override
	public Shebeiyunxing2 quchongShebeiyunxing(Map<String, Object> account) {
		return gdao.quchongShebeiyunxing(account);
	}

	@Override
	public List<Shebeiyunxing2> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shebeiyunxing2> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shebeiyunxing2 getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

