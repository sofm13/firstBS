package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Weijianjihua;

public interface WeijianjihuaServer {

  public int add(Weijianjihua po);

  public int update(Weijianjihua po);
  
  
  
  public int delete(int id);

  public List<Weijianjihua> getAll(Map<String,Object> map);
  public List<Weijianjihua> getsyweijianjihua1(Map<String,Object> map);
  public List<Weijianjihua> getsyweijianjihua2(Map<String,Object> map);
  public List<Weijianjihua> getsyweijianjihua3(Map<String,Object> map);
  public Weijianjihua quchongWeijianjihua(Map<String, Object> acount);

  public Weijianjihua getById( int id);

  public List<Weijianjihua> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Weijianjihua> select(Map<String, Object> map);
}
//	所有List
