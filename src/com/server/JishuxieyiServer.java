package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jishuxieyi;

public interface JishuxieyiServer {

  public int add(Jishuxieyi po);

  public int update(Jishuxieyi po);
  
  
  
  public int delete(int id);

  public List<Jishuxieyi> getAll(Map<String,Object> map);
  public List<Jishuxieyi> getsyjishuxieyi1(Map<String,Object> map);
  public List<Jishuxieyi> getsyjishuxieyi2(Map<String,Object> map);
  public List<Jishuxieyi> getsyjishuxieyi3(Map<String,Object> map);
  public Jishuxieyi quchongJishuxieyi(Map<String, Object> acount);

  public Jishuxieyi getById( int id);

  public List<Jishuxieyi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jishuxieyi> select(Map<String, Object> map);
}
//	所有List
