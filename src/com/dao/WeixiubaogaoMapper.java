package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Weixiubaogao;

public interface WeixiubaogaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Weixiubaogao record);

    int insertSelective(Weixiubaogao record);

    Weixiubaogao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Weixiubaogao record);
	
    int updateByPrimaryKey(Weixiubaogao record);
	public Weixiubaogao quchongWeixiubaogao(Map<String, Object> bianhao);
	public List<Weixiubaogao> getAll(Map<String, Object> map);
	public List<Weixiubaogao> getsyweixiubaogao1(Map<String, Object> map);
	public List<Weixiubaogao> getsyweixiubaogao3(Map<String, Object> map);
	public List<Weixiubaogao> getsyweixiubaogao2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Weixiubaogao> getByPage(Map<String, Object> map);
	public List<Weixiubaogao> select(Map<String, Object> map);
//	所有List
}

