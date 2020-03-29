package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Baofeishenqing;

public interface BaofeishenqingServer {

  public int add(Baofeishenqing po);

  public int update(Baofeishenqing po);
  
  
  
  public int delete(int id);

  public List<Baofeishenqing> getAll(Map<String,Object> map);
  public List<Baofeishenqing> getsybaofeishenqing1(Map<String,Object> map);
  public List<Baofeishenqing> getsybaofeishenqing2(Map<String,Object> map);
  public List<Baofeishenqing> getsybaofeishenqing3(Map<String,Object> map);
  public Baofeishenqing quchongBaofeishenqing(Map<String, Object> acount);

  public Baofeishenqing getById( int id);

  public List<Baofeishenqing> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Baofeishenqing> select(Map<String, Object> map);
}
//	所有List
