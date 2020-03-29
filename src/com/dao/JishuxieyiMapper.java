package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jishuxieyi;

public interface JishuxieyiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jishuxieyi record);

    int insertSelective(Jishuxieyi record);

    Jishuxieyi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jishuxieyi record);
	
    int updateByPrimaryKey(Jishuxieyi record);
	public Jishuxieyi quchongJishuxieyi(Map<String, Object> xieyibianhao);
	public List<Jishuxieyi> getAll(Map<String, Object> map);
	public List<Jishuxieyi> getsyjishuxieyi1(Map<String, Object> map);
	public List<Jishuxieyi> getsyjishuxieyi3(Map<String, Object> map);
	public List<Jishuxieyi> getsyjishuxieyi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jishuxieyi> getByPage(Map<String, Object> map);
	public List<Jishuxieyi> select(Map<String, Object> map);
//	所有List
}

