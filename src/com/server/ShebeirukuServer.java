package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shebeiruku;

public interface ShebeirukuServer {

  public int add(Shebeiruku po);

  public int update(Shebeiruku po);
  
  
  
  public int delete(int id);

  public List<Shebeiruku> getAll(Map<String,Object> map);
  public List<Shebeiruku> getsyshebeiruku1(Map<String,Object> map);
  public List<Shebeiruku> getsyshebeiruku2(Map<String,Object> map);
  public List<Shebeiruku> getsyshebeiruku3(Map<String,Object> map);
  public Shebeiruku quchongShebeiruku(Map<String, Object> acount);

  public Shebeiruku getById( int id);

  public List<Shebeiruku> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shebeiruku> select(Map<String, Object> map);
}
//	所有List
