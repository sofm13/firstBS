package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Bumenguanli;

public interface BumenguanliServer {

  public int add(Bumenguanli po);

  public int update(Bumenguanli po);
  
  
  
  public int delete(int id);

  public List<Bumenguanli> getAll(Map<String,Object> map);
  public List<Bumenguanli> getsybumenguanli1(Map<String,Object> map);
  public List<Bumenguanli> getsybumenguanli2(Map<String,Object> map);
  public List<Bumenguanli> getsybumenguanli3(Map<String,Object> map);
  public Bumenguanli quchongBumenguanli(Map<String, Object> acount);

  public Bumenguanli getById( int id);

  public List<Bumenguanli> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Bumenguanli> select(Map<String, Object> map);
}
//	所有List
