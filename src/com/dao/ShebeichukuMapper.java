package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shebeichuku;

public interface ShebeichukuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shebeichuku record);

    int insertSelective(Shebeichuku record);

    Shebeichuku selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shebeichuku record);
	
    int updateByPrimaryKey(Shebeichuku record);
	public Shebeichuku quchongShebeichuku(Map<String, Object> bianhao);
	public List<Shebeichuku> getAll(Map<String, Object> map);
	public List<Shebeichuku> getsyshebeichuku1(Map<String, Object> map);
	public List<Shebeichuku> getsyshebeichuku3(Map<String, Object> map);
	public List<Shebeichuku> getsyshebeichuku2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shebeichuku> getByPage(Map<String, Object> map);
	public List<Shebeichuku> select(Map<String, Object> map);
//	所有List
}

