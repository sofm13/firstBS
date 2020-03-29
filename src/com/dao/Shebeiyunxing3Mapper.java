package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shebeiyunxing3;

public interface Shebeiyunxing3Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shebeiyunxing3 record);

    int insertSelective(Shebeiyunxing3 record);

    Shebeiyunxing3 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shebeiyunxing3 record);
	
    int updateByPrimaryKey(Shebeiyunxing3 record);
	public Shebeiyunxing3 quchongShebeiyunxing(Map<String, Object> bianhao);
	public List<Shebeiyunxing3> getAll(Map<String, Object> map);
	public List<Shebeiyunxing3> getsyshebeiyunxing1(Map<String, Object> map);
	public List<Shebeiyunxing3> getsyshebeiyunxing3(Map<String, Object> map);
	public List<Shebeiyunxing3> getsyshebeiyunxing2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shebeiyunxing3> getByPage(Map<String, Object> map);
	public List<Shebeiyunxing3> select(Map<String, Object> map);
//	所有List
}

