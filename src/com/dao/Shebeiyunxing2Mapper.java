package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shebeiyunxing2;

public interface Shebeiyunxing2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shebeiyunxing2 record);

    int insertSelective(Shebeiyunxing2 record);

    Shebeiyunxing2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shebeiyunxing2 record);
	
    int updateByPrimaryKey(Shebeiyunxing2 record);
	public Shebeiyunxing2 quchongShebeiyunxing(Map<String, Object> bianhao);
	public List<Shebeiyunxing2> getAll(Map<String, Object> map);
	public List<Shebeiyunxing2> getsyshebeiyunxing1(Map<String, Object> map);
	public List<Shebeiyunxing2> getsyshebeiyunxing3(Map<String, Object> map);
	public List<Shebeiyunxing2> getsyshebeiyunxing2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shebeiyunxing2> getByPage(Map<String, Object> map);
	public List<Shebeiyunxing2> select(Map<String, Object> map);
//	所有List
}

