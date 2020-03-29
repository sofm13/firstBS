package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shebeiyunxing2;

public interface Shebeiyunxing2Server {

  public int add(Shebeiyunxing2 po);

  public int update(Shebeiyunxing2 po);
  
  
  
  public int delete(int id);

  public List<Shebeiyunxing2> getAll(Map<String,Object> map);
  public List<Shebeiyunxing2> getsyshebeiyunxing1(Map<String,Object> map);
  public List<Shebeiyunxing2> getsyshebeiyunxing2(Map<String,Object> map);
  public List<Shebeiyunxing2> getsyshebeiyunxing3(Map<String,Object> map);
  public Shebeiyunxing2 quchongShebeiyunxing(Map<String, Object> acount);

  public Shebeiyunxing2 getById( int id);

  public List<Shebeiyunxing2> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shebeiyunxing2> select(Map<String, Object> map);
}
//	所有List
