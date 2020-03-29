package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shebeiyunxing1;

public interface Shebeiyunxing1Server {

  public int add(Shebeiyunxing1 po);

  public int update(Shebeiyunxing1 po);
  
  
  
  public int delete(int id);

  public List<Shebeiyunxing1> getAll(Map<String,Object> map);
  public List<Shebeiyunxing1> getsyshebeiyunxing1(Map<String,Object> map);
  public List<Shebeiyunxing1> getsyshebeiyunxing2(Map<String,Object> map);
  public List<Shebeiyunxing1> getsyshebeiyunxing3(Map<String,Object> map);
  public Shebeiyunxing1 quchongShebeiyunxing(Map<String, Object> acount);

  public Shebeiyunxing1 getById( int id);

  public List<Shebeiyunxing1> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shebeiyunxing1> select(Map<String, Object> map);
}
//	所有List
