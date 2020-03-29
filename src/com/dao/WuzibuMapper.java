package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Wuzibu;

public interface WuzibuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wuzibu record);

    int insertSelective(Wuzibu record);

    Wuzibu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wuzibu record);
	
    int updateByPrimaryKey(Wuzibu record);
	public Wuzibu quchongWuzibu(Map<String, Object> zhanghao);
	public List<Wuzibu> getAll(Map<String, Object> map);
	public List<Wuzibu> getsywuzibu1(Map<String, Object> map);
	public List<Wuzibu> getsywuzibu3(Map<String, Object> map);
	public List<Wuzibu> getsywuzibu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Wuzibu> getByPage(Map<String, Object> map);
	public List<Wuzibu> select(Map<String, Object> map);
//	所有List
}

