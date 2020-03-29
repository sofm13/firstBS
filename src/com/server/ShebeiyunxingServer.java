package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shebeiyunxing;

public interface ShebeiyunxingServer {

  public int add(Shebeiyunxing po);

  public int update(Shebeiyunxing po);
  
  
  
  public int delete(int id);

  public List<Shebeiyunxing> getAll(Map<String,Object> map);
  public List<Shebeiyunxing> getsyshebeiyunxing1(Map<String,Object> map);
  public List<Shebeiyunxing> getsyshebeiyunxing2(Map<String,Object> map);
  public List<Shebeiyunxing> getsyshebeiyunxing3(Map<String,Object> map);
  public Shebeiyunxing quchongShebeiyunxing(Map<String, Object> acount);

  public Shebeiyunxing getById( int id);

  public List<Shebeiyunxing> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shebeiyunxing> select(Map<String, Object> map);
}
//	所有List
