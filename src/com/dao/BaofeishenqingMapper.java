package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Baofeishenqing;

public interface BaofeishenqingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Baofeishenqing record);

    int insertSelective(Baofeishenqing record);

    Baofeishenqing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Baofeishenqing record);
	
    int updateByPrimaryKey(Baofeishenqing record);
	public Baofeishenqing quchongBaofeishenqing(Map<String, Object> baofeiren);
	public List<Baofeishenqing> getAll(Map<String, Object> map);
	public List<Baofeishenqing> getsybaofeishenqing1(Map<String, Object> map);
	public List<Baofeishenqing> getsybaofeishenqing3(Map<String, Object> map);
	public List<Baofeishenqing> getsybaofeishenqing2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Baofeishenqing> getByPage(Map<String, Object> map);
	public List<Baofeishenqing> select(Map<String, Object> map);
//	所有List
}

