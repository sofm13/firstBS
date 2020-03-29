package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shebeiyunxing1;

public interface Shebeiyunxing1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shebeiyunxing1 record);

    int insertSelective(Shebeiyunxing1 record);

    Shebeiyunxing1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shebeiyunxing1 record);
	
    int updateByPrimaryKey(Shebeiyunxing1 record);
	public Shebeiyunxing1 quchongShebeiyunxing(Map<String, Object> bianhao);
	public List<Shebeiyunxing1> getAll(Map<String, Object> map);
	public List<Shebeiyunxing1> getsyshebeiyunxing1(Map<String, Object> map);
	public List<Shebeiyunxing1> getsyshebeiyunxing3(Map<String, Object> map);
	public List<Shebeiyunxing1> getsyshebeiyunxing2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shebeiyunxing1> getByPage(Map<String, Object> map);
	public List<Shebeiyunxing1> select(Map<String, Object> map);
//	所有List
}

