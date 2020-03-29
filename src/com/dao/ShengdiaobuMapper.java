package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shengdiaobu;

public interface ShengdiaobuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shengdiaobu record);

    int insertSelective(Shengdiaobu record);

    Shengdiaobu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shengdiaobu record);
	
    int updateByPrimaryKey(Shengdiaobu record);
	public Shengdiaobu quchongShengdiaobu(Map<String, Object> zhanghao);
	public List<Shengdiaobu> getAll(Map<String, Object> map);
	public List<Shengdiaobu> getsyshengdiaobu1(Map<String, Object> map);
	public List<Shengdiaobu> getsyshengdiaobu3(Map<String, Object> map);
	public List<Shengdiaobu> getsyshengdiaobu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shengdiaobu> getByPage(Map<String, Object> map);
	public List<Shengdiaobu> select(Map<String, Object> map);
//	所有List
}

