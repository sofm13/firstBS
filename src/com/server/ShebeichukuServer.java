package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shebeichuku;

public interface ShebeichukuServer {

  public int add(Shebeichuku po);

  public int update(Shebeichuku po);
  
  
  
  public int delete(int id);

  public List<Shebeichuku> getAll(Map<String,Object> map);
  public List<Shebeichuku> getsyshebeichuku1(Map<String,Object> map);
  public List<Shebeichuku> getsyshebeichuku2(Map<String,Object> map);
  public List<Shebeichuku> getsyshebeichuku3(Map<String,Object> map);
  public Shebeichuku quchongShebeichuku(Map<String, Object> acount);

  public Shebeichuku getById( int id);

  public List<Shebeichuku> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shebeichuku> select(Map<String, Object> map);
}
//	所有List
