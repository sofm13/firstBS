package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Weixiubaogao;

public interface WeixiubaogaoServer {

  public int add(Weixiubaogao po);

  public int update(Weixiubaogao po);
  
  
  
  public int delete(int id);

  public List<Weixiubaogao> getAll(Map<String,Object> map);
  public List<Weixiubaogao> getsyweixiubaogao1(Map<String,Object> map);
  public List<Weixiubaogao> getsyweixiubaogao2(Map<String,Object> map);
  public List<Weixiubaogao> getsyweixiubaogao3(Map<String,Object> map);
  public Weixiubaogao quchongWeixiubaogao(Map<String, Object> acount);

  public Weixiubaogao getById( int id);

  public List<Weixiubaogao> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Weixiubaogao> select(Map<String, Object> map);
}
//	所有List
