package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Chukushenqing;

public interface ChukushenqingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chukushenqing record);

    int insertSelective(Chukushenqing record);

    Chukushenqing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chukushenqing record);
	
    int updateByPrimaryKey(Chukushenqing record);
	public Chukushenqing quchongChukushenqing(Map<String, Object> shenqingren);
	public List<Chukushenqing> getAll(Map<String, Object> map);
	public List<Chukushenqing> getsychukushenqing1(Map<String, Object> map);
	public List<Chukushenqing> getsychukushenqing3(Map<String, Object> map);
	public List<Chukushenqing> getsychukushenqing2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Chukushenqing> getByPage(Map<String, Object> map);
	public List<Chukushenqing> select(Map<String, Object> map);
//	所有List
}

