package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Weijianjihua1;

public interface Weijianjihua1Server {

  public int add(Weijianjihua1 po);

  public int update(Weijianjihua1 po);
  
  
  
  public int delete(int id);

  public List<Weijianjihua1> getAll(Map<String,Object> map);
  public List<Weijianjihua1> getsyweijianjihua1(Map<String,Object> map);
  public List<Weijianjihua1> getsyweijianjihua2(Map<String,Object> map);
  public List<Weijianjihua1> getsyweijianjihua3(Map<String,Object> map);
  public Weijianjihua1 quchongWeijianjihua(Map<String, Object> acount);

  public Weijianjihua1 getById( int id);

  public List<Weijianjihua1> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Weijianjihua1> select(Map<String, Object> map);
}
//	所有List
