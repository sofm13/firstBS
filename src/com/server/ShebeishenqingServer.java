package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shebeishenqing;

public interface ShebeishenqingServer {

  public int add(Shebeishenqing po);

  public int update(Shebeishenqing po);
  
  
  
  public int delete(int id);

  public List<Shebeishenqing> getAll(Map<String,Object> map);
  public List<Shebeishenqing> getsyshebeishenqing1(Map<String,Object> map);
  public List<Shebeishenqing> getsyshebeishenqing2(Map<String,Object> map);
  public List<Shebeishenqing> getsyshebeishenqing3(Map<String,Object> map);
  public Shebeishenqing quchongShebeishenqing(Map<String, Object> acount);

  public Shebeishenqing getById( int id);

  public List<Shebeishenqing> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shebeishenqing> select(Map<String, Object> map);
}
//	所有List
