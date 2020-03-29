package com.entity;

public class Fapiaoguanli {
    private Integer id;
	private String bianhao;	private String shebeimingcheng;	private String fapiaobianhao;	private String fapiaoneirong;	private String fapiaojine;	private String jiluren;	
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
    }	public String getFapiaobianhao() {
        return fapiaobianhao;
    }
    public void setFapiaobianhao(String fapiaobianhao) {
        this.fapiaobianhao = fapiaobianhao == null ? null : fapiaobianhao.trim();
    }	public String getFapiaoneirong() {
        return fapiaoneirong;
    }
    public void setFapiaoneirong(String fapiaoneirong) {
        this.fapiaoneirong = fapiaoneirong == null ? null : fapiaoneirong.trim();
    }	public String getFapiaojine() {
        return fapiaojine;
    }
    public void setFapiaojine(String fapiaojine) {
        this.fapiaojine = fapiaojine == null ? null : fapiaojine.trim();
    }	public String getJiluren() {
        return jiluren;
    }
    public void setJiluren(String jiluren) {
        this.jiluren = jiluren == null ? null : jiluren.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
