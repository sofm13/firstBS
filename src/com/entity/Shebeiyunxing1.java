package com.entity;

public class Shebeiyunxing1 {
    private Integer id;
	private String bianhao;	private String shebeimingcheng;	private String rizhi;	private String canshu;	private String issh;	
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
    }	public String getRizhi() {
        return rizhi;
    }
    public void setRizhi(String rizhi) {
        this.rizhi = rizhi == null ? null : rizhi.trim();
    }	public String getCanshu() {
        return canshu;
    }
    public void setCanshu(String canshu) {
        this.canshu = canshu == null ? null : canshu.trim();
    }	public String getIssh() {
        return issh;
    }
    public void setIssh(String issh) {
        this.issh = issh == null ? null : issh.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
