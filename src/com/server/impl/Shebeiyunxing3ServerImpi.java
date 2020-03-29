package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.Shebeiyunxing3Mapper;
import com.entity.Shebeiyunxing3;
import com.server.Shebeiyunxing3Server;
@Service
public class Shebeiyunxing3ServerImpi implements Shebeiyunxing3Server {
   @Resource
   private Shebeiyunxing3Mapper gdao;
	@Override
	public int add(Shebeiyunxing3 po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shebeiyunxing3 po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shebeiyunxing3> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shebeiyunxing3> getsyshebeiyunxing1(Map<String, Object> map) {
		return gdao.getsyshebeiyunxing1(map);
	}
	public List<Shebeiyunxing3> getsyshebeiyunxing2(Map<String, Object> map) {
		return gdao.getsyshebeiyunxing2(map);
	}
	public List<Shebeiyunxing3> getsyshebeiyunxing3(Map<String, Object> map) {
		return gdao.getsyshebeiyunxing3(map);
	}
	
	@Override
	public Shebeiyunxing3 quchongShebeiyunxing(Map<String, Object> account) {
		return gdao.quchongShebeiyunxing(account);
	}

	@Override
	public List<Shebeiyunxing3> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shebeiyunxing3> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shebeiyunxing3 getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

