package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shebeiyunxing3;

public interface Shebeiyunxing3Server {

  public int add(Shebeiyunxing3 po);

  public int update(Shebeiyunxing3 po);
  
  
  
  public int delete(int id);

  public List<Shebeiyunxing3> getAll(Map<String,Object> map);
  public List<Shebeiyunxing3> getsyshebeiyunxing1(Map<String,Object> map);
  public List<Shebeiyunxing3> getsyshebeiyunxing2(Map<String,Object> map);
  public List<Shebeiyunxing3> getsyshebeiyunxing3(Map<String,Object> map);
  public Shebeiyunxing3 quchongShebeiyunxing(Map<String, Object> acount);

  public Shebeiyunxing3 getById( int id);

  public List<Shebeiyunxing3> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shebeiyunxing3> select(Map<String, Object> map);
}
//	所有List
