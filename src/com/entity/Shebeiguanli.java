﻿package com.entity;

public class Shebeiguanli {
    private Integer id;
	private String bianhao;
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getBianhao() {
        return bianhao;
    }
    public void setBianhao(String bianhao) {
        this.bianhao = bianhao == null ? null : bianhao.trim();
    }
        return shebeimingcheng;
    }
    public void setShebeimingcheng(String shebeimingcheng) {
        this.shebeimingcheng = shebeimingcheng == null ? null : shebeimingcheng.trim();
    }
        return kucun;
    }
    public void setKucun(String kucun) {
        this.kucun = kucun == null ? null : kucun.trim();
    }
        return shebeixiangqing;
    }
    public void setShebeixiangqing(String shebeixiangqing) {
        this.shebeixiangqing = shebeixiangqing == null ? null : shebeixiangqing.trim();
    }
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息