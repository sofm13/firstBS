package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shebeiruku;

public interface ShebeirukuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shebeiruku record);

    int insertSelective(Shebeiruku record);

    Shebeiruku selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shebeiruku record);
	
    int updateByPrimaryKey(Shebeiruku record);
	public Shebeiruku quchongShebeiruku(Map<String, Object> bianhao);
	public List<Shebeiruku> getAll(Map<String, Object> map);
	public List<Shebeiruku> getsyshebeiruku1(Map<String, Object> map);
	public List<Shebeiruku> getsyshebeiruku3(Map<String, Object> map);
	public List<Shebeiruku> getsyshebeiruku2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shebeiruku> getByPage(Map<String, Object> map);
	public List<Shebeiruku> select(Map<String, Object> map);
//	所有List
}

