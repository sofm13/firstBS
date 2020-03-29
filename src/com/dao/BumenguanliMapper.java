package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Bumenguanli;

public interface BumenguanliMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bumenguanli record);

    int insertSelective(Bumenguanli record);

    Bumenguanli selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bumenguanli record);
	
    int updateByPrimaryKey(Bumenguanli record);
	public Bumenguanli quchongBumenguanli(Map<String, Object> bumenbianhao);
	public List<Bumenguanli> getAll(Map<String, Object> map);
	public List<Bumenguanli> getsybumenguanli1(Map<String, Object> map);
	public List<Bumenguanli> getsybumenguanli3(Map<String, Object> map);
	public List<Bumenguanli> getsybumenguanli2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Bumenguanli> getByPage(Map<String, Object> map);
	public List<Bumenguanli> select(Map<String, Object> map);
//	所有List
}

