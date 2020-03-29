package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shebeiyunxing;

public interface ShebeiyunxingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shebeiyunxing record);

    int insertSelective(Shebeiyunxing record);

    Shebeiyunxing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shebeiyunxing record);
	
    int updateByPrimaryKey(Shebeiyunxing record);
	public Shebeiyunxing quchongShebeiyunxing(Map<String, Object> bianhao);
	public List<Shebeiyunxing> getAll(Map<String, Object> map);
	public List<Shebeiyunxing> getsyshebeiyunxing1(Map<String, Object> map);
	public List<Shebeiyunxing> getsyshebeiyunxing3(Map<String, Object> map);
	public List<Shebeiyunxing> getsyshebeiyunxing2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shebeiyunxing> getByPage(Map<String, Object> map);
	public List<Shebeiyunxing> select(Map<String, Object> map);
//	所有List
}

