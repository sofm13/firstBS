﻿package com.entity;

public class Jianyijihua {
    private Integer id;
	private String jihuamingcheng;
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getJihuamingcheng() {
        return jihuamingcheng;
    }
    public void setJihuamingcheng(String jihuamingcheng) {
        this.jihuamingcheng = jihuamingcheng == null ? null : jihuamingcheng.trim();
    }
        return jihuamiaoshu;
    }
    public void setJihuamiaoshu(String jihuamiaoshu) {
        this.jihuamiaoshu = jihuamiaoshu == null ? null : jihuamiaoshu.trim();
    }
        return lurushijian;
    }
    public void setLurushijian(String lurushijian) {
        this.lurushijian = lurushijian == null ? null : lurushijian.trim();
    }
        return lururenyuan;
    }
    public void setLururenyuan(String lururenyuan) {
        this.lururenyuan = lururenyuan == null ? null : lururenyuan.trim();
    }
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息