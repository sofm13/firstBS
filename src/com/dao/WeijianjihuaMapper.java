package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Weijianjihua;

public interface WeijianjihuaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Weijianjihua record);

    int insertSelective(Weijianjihua record);

    Weijianjihua selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Weijianjihua record);
	
    int updateByPrimaryKey(Weijianjihua record);
	public Weijianjihua quchongWeijianjihua(Map<String, Object> lururenyuan);
	public List<Weijianjihua> getAll(Map<String, Object> map);
	public List<Weijianjihua> getsyweijianjihua1(Map<String, Object> map);
	public List<Weijianjihua> getsyweijianjihua3(Map<String, Object> map);
	public List<Weijianjihua> getsyweijianjihua2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Weijianjihua> getByPage(Map<String, Object> map);
	public List<Weijianjihua> select(Map<String, Object> map);
//	所有List
}

