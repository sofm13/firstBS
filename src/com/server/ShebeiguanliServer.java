package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shebeiguanli;

public interface ShebeiguanliServer {

  public int add(Shebeiguanli po);

  public int update(Shebeiguanli po);
  
  
  
  public int delete(int id);

  public List<Shebeiguanli> getAll(Map<String,Object> map);
  public List<Shebeiguanli> getsyshebeiguanli1(Map<String,Object> map);
  public List<Shebeiguanli> getsyshebeiguanli2(Map<String,Object> map);
  public List<Shebeiguanli> getsyshebeiguanli3(Map<String,Object> map);
  public Shebeiguanli quchongShebeiguanli(Map<String, Object> acount);

  public Shebeiguanli getById( int id);

  public List<Shebeiguanli> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shebeiguanli> select(Map<String, Object> map);
}
//	所有List
