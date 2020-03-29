package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Weixiushenqing;

public interface WeixiushenqingServer {

  public int add(Weixiushenqing po);

  public int update(Weixiushenqing po);
  
  
  
  public int delete(int id);

  public List<Weixiushenqing> getAll(Map<String,Object> map);
  public List<Weixiushenqing> getsyweixiushenqing1(Map<String,Object> map);
  public List<Weixiushenqing> getsyweixiushenqing2(Map<String,Object> map);
  public List<Weixiushenqing> getsyweixiushenqing3(Map<String,Object> map);
  public Weixiushenqing quchongWeixiushenqing(Map<String, Object> acount);

  public Weixiushenqing getById( int id);

  public List<Weixiushenqing> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Weixiushenqing> select(Map<String, Object> map);
}
//	所有List
