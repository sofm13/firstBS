package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shebeishenqing;

public interface ShebeishenqingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shebeishenqing record);

    int insertSelective(Shebeishenqing record);

    Shebeishenqing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shebeishenqing record);
	
    int updateByPrimaryKey(Shebeishenqing record);
	public Shebeishenqing quchongShebeishenqing(Map<String, Object> shenqingren);
	public List<Shebeishenqing> getAll(Map<String, Object> map);
	public List<Shebeishenqing> getsyshebeishenqing1(Map<String, Object> map);
	public List<Shebeishenqing> getsyshebeishenqing3(Map<String, Object> map);
	public List<Shebeishenqing> getsyshebeishenqing2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shebeishenqing> getByPage(Map<String, Object> map);
	public List<Shebeishenqing> select(Map<String, Object> map);
//	所有List
}

