package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Fapiaoguanli;

public interface FapiaoguanliMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fapiaoguanli record);

    int insertSelective(Fapiaoguanli record);

    Fapiaoguanli selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fapiaoguanli record);
	
    int updateByPrimaryKey(Fapiaoguanli record);
	public Fapiaoguanli quchongFapiaoguanli(Map<String, Object> bianhao);
	public List<Fapiaoguanli> getAll(Map<String, Object> map);
	public List<Fapiaoguanli> getsyfapiaoguanli1(Map<String, Object> map);
	public List<Fapiaoguanli> getsyfapiaoguanli3(Map<String, Object> map);
	public List<Fapiaoguanli> getsyfapiaoguanli2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Fapiaoguanli> getByPage(Map<String, Object> map);
	public List<Fapiaoguanli> select(Map<String, Object> map);
//	所有List
}

