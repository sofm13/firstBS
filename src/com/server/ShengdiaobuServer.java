package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shengdiaobu;

public interface ShengdiaobuServer {

  public int add(Shengdiaobu po);

  public int update(Shengdiaobu po);
  
  
  
  public int delete(int id);

  public List<Shengdiaobu> getAll(Map<String,Object> map);
  public List<Shengdiaobu> getsyshengdiaobu1(Map<String,Object> map);
  public List<Shengdiaobu> getsyshengdiaobu2(Map<String,Object> map);
  public List<Shengdiaobu> getsyshengdiaobu3(Map<String,Object> map);
  public Shengdiaobu quchongShengdiaobu(Map<String, Object> acount);

  public Shengdiaobu getById( int id);

  public List<Shengdiaobu> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shengdiaobu> select(Map<String, Object> map);
}
//	所有List
