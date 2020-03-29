package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Fapiaoguanli;

public interface FapiaoguanliServer {

  public int add(Fapiaoguanli po);

  public int update(Fapiaoguanli po);
  
  
  
  public int delete(int id);

  public List<Fapiaoguanli> getAll(Map<String,Object> map);
  public List<Fapiaoguanli> getsyfapiaoguanli1(Map<String,Object> map);
  public List<Fapiaoguanli> getsyfapiaoguanli2(Map<String,Object> map);
  public List<Fapiaoguanli> getsyfapiaoguanli3(Map<String,Object> map);
  public Fapiaoguanli quchongFapiaoguanli(Map<String, Object> acount);

  public Fapiaoguanli getById( int id);

  public List<Fapiaoguanli> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Fapiaoguanli> select(Map<String, Object> map);
}
//	所有List
