package com.entity;

public class Weixiubaogao {
    private Integer id;
	private String bianhao;	private String shebeimingcheng;	private String qingkuangjianshu;	private String weixiuyuanyin;	private String weixiujieguo;	private String weixiuren;	
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
    }	public String getQingkuangjianshu() {
        return qingkuangjianshu;
    }
    public void setQingkuangjianshu(String qingkuangjianshu) {
        this.qingkuangjianshu = qingkuangjianshu == null ? null : qingkuangjianshu.trim();
    }	public String getWeixiuyuanyin() {
        return weixiuyuanyin;
    }
    public void setWeixiuyuanyin(String weixiuyuanyin) {
        this.weixiuyuanyin = weixiuyuanyin == null ? null : weixiuyuanyin.trim();
    }	public String getWeixiujieguo() {
        return weixiujieguo;
    }
    public void setWeixiujieguo(String weixiujieguo) {
        this.weixiujieguo = weixiujieguo == null ? null : weixiujieguo.trim();
    }	public String getWeixiuren() {
        return weixiuren;
    }
    public void setWeixiuren(String weixiuren) {
        this.weixiuren = weixiuren == null ? null : weixiuren.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
