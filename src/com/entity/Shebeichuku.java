package com.entity;

public class Shebeichuku {
    private Integer id;
	private String bianhao;	private String shebeimingcheng;	private String kucun;	private String shenqingshuliang;	
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
    }	public String getShebeimingcheng() {
        return shebeimingcheng;
    }
    public void setShebeimingcheng(String shebeimingcheng) {
        this.shebeimingcheng = shebeimingcheng == null ? null : shebeimingcheng.trim();
    }	public String getKucun() {
        return kucun;
    }
    public void setKucun(String kucun) {
        this.kucun = kucun == null ? null : kucun.trim();
    }	public String getShenqingshuliang() {
        return shenqingshuliang;
    }
    public void setShenqingshuliang(String shenqingshuliang) {
        this.shenqingshuliang = shenqingshuliang == null ? null : shenqingshuliang.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
