package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shebeiguanli;

public interface ShebeiguanliMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shebeiguanli record);

    int insertSelective(Shebeiguanli record);

    Shebeiguanli selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shebeiguanli record);
	
    int updateByPrimaryKey(Shebeiguanli record);
	public Shebeiguanli quchongShebeiguanli(Map<String, Object> bianhao);
	public List<Shebeiguanli> getAll(Map<String, Object> map);
	public List<Shebeiguanli> getsyshebeiguanli1(Map<String, Object> map);
	public List<Shebeiguanli> getsyshebeiguanli3(Map<String, Object> map);
	public List<Shebeiguanli> getsyshebeiguanli2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shebeiguanli> getByPage(Map<String, Object> map);
	public List<Shebeiguanli> select(Map<String, Object> map);
//	所有List
}

