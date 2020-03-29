package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jianyijihua;

public interface JianyijihuaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jianyijihua record);

    int insertSelective(Jianyijihua record);

    Jianyijihua selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jianyijihua record);
	
    int updateByPrimaryKey(Jianyijihua record);
	public Jianyijihua quchongJianyijihua(Map<String, Object> lururenyuan);
	public List<Jianyijihua> getAll(Map<String, Object> map);
	public List<Jianyijihua> getsyjianyijihua1(Map<String, Object> map);
	public List<Jianyijihua> getsyjianyijihua3(Map<String, Object> map);
	public List<Jianyijihua> getsyjianyijihua2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jianyijihua> getByPage(Map<String, Object> map);
	public List<Jianyijihua> select(Map<String, Object> map);
//	所有List
}

