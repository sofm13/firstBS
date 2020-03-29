package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Hetongshengcheng;

public interface HetongshengchengMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hetongshengcheng record);

    int insertSelective(Hetongshengcheng record);

    Hetongshengcheng selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hetongshengcheng record);
	
    int updateByPrimaryKey(Hetongshengcheng record);
	public Hetongshengcheng quchongHetongshengcheng(Map<String, Object> bianhao);
	public List<Hetongshengcheng> getAll(Map<String, Object> map);
	public List<Hetongshengcheng> getsyhetongshengcheng1(Map<String, Object> map);
	public List<Hetongshengcheng> getsyhetongshengcheng3(Map<String, Object> map);
	public List<Hetongshengcheng> getsyhetongshengcheng2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Hetongshengcheng> getByPage(Map<String, Object> map);
	public List<Hetongshengcheng> select(Map<String, Object> map);
//	所有List
}

