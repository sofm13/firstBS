package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Weixiushenqing;

public interface WeixiushenqingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Weixiushenqing record);

    int insertSelective(Weixiushenqing record);

    Weixiushenqing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Weixiushenqing record);
	
    int updateByPrimaryKey(Weixiushenqing record);
	public Weixiushenqing quchongWeixiushenqing(Map<String, Object> shenqingren);
	public List<Weixiushenqing> getAll(Map<String, Object> map);
	public List<Weixiushenqing> getsyweixiushenqing1(Map<String, Object> map);
	public List<Weixiushenqing> getsyweixiushenqing3(Map<String, Object> map);
	public List<Weixiushenqing> getsyweixiushenqing2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Weixiushenqing> getByPage(Map<String, Object> map);
	public List<Weixiushenqing> select(Map<String, Object> map);
//	所有List
}

