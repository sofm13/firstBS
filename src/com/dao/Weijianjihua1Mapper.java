package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Weijianjihua1;

public interface Weijianjihua1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Weijianjihua1 record);

    int insertSelective(Weijianjihua1 record);

    Weijianjihua1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Weijianjihua1 record);
	
    int updateByPrimaryKey(Weijianjihua1 record);
	public Weijianjihua1 quchongWeijianjihua(Map<String, Object> lururenyuan);
	public List<Weijianjihua1> getAll(Map<String, Object> map);
	public List<Weijianjihua1> getsyweijianjihua1(Map<String, Object> map);
	public List<Weijianjihua1> getsyweijianjihua3(Map<String, Object> map);
	public List<Weijianjihua1> getsyweijianjihua2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Weijianjihua1> getByPage(Map<String, Object> map);
	public List<Weijianjihua1> select(Map<String, Object> map);
//	所有List
}

