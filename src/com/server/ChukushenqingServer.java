package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Chukushenqing;

public interface ChukushenqingServer {

  public int add(Chukushenqing po);

  public int update(Chukushenqing po);
  
  
  
  public int delete(int id);

  public List<Chukushenqing> getAll(Map<String,Object> map);
  public List<Chukushenqing> getsychukushenqing1(Map<String,Object> map);
  public List<Chukushenqing> getsychukushenqing2(Map<String,Object> map);
  public List<Chukushenqing> getsychukushenqing3(Map<String,Object> map);
  public Chukushenqing quchongChukushenqing(Map<String, Object> acount);

  public Chukushenqing getById( int id);

  public List<Chukushenqing> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Chukushenqing> select(Map<String, Object> map);
}
//	所有List
