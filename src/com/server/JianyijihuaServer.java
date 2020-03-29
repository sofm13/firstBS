package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jianyijihua;

public interface JianyijihuaServer {

  public int add(Jianyijihua po);

  public int update(Jianyijihua po);
  
  
  
  public int delete(int id);

  public List<Jianyijihua> getAll(Map<String,Object> map);
  public List<Jianyijihua> getsyjianyijihua1(Map<String,Object> map);
  public List<Jianyijihua> getsyjianyijihua2(Map<String,Object> map);
  public List<Jianyijihua> getsyjianyijihua3(Map<String,Object> map);
  public Jianyijihua quchongJianyijihua(Map<String, Object> acount);

  public Jianyijihua getById( int id);

  public List<Jianyijihua> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jianyijihua> select(Map<String, Object> map);
}
//	所有List
