package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Wuzibu;

public interface WuzibuServer {

  public int add(Wuzibu po);

  public int update(Wuzibu po);
  
  
  
  public int delete(int id);

  public List<Wuzibu> getAll(Map<String,Object> map);
  public List<Wuzibu> getsywuzibu1(Map<String,Object> map);
  public List<Wuzibu> getsywuzibu2(Map<String,Object> map);
  public List<Wuzibu> getsywuzibu3(Map<String,Object> map);
  public Wuzibu quchongWuzibu(Map<String, Object> acount);

  public Wuzibu getById( int id);

  public List<Wuzibu> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Wuzibu> select(Map<String, Object> map);
}
//	所有List
