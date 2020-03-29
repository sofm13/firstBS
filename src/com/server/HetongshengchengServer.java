package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Hetongshengcheng;

public interface HetongshengchengServer {

  public int add(Hetongshengcheng po);

  public int update(Hetongshengcheng po);
  
  
  
  public int delete(int id);

  public List<Hetongshengcheng> getAll(Map<String,Object> map);
  public List<Hetongshengcheng> getsyhetongshengcheng1(Map<String,Object> map);
  public List<Hetongshengcheng> getsyhetongshengcheng2(Map<String,Object> map);
  public List<Hetongshengcheng> getsyhetongshengcheng3(Map<String,Object> map);
  public Hetongshengcheng quchongHetongshengcheng(Map<String, Object> acount);

  public Hetongshengcheng getById( int id);

  public List<Hetongshengcheng> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Hetongshengcheng> select(Map<String, Object> map);
}
//	所有List
