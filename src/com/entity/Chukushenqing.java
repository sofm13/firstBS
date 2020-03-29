package com.entity;

public class Chukushenqing {
    private Integer id;
	private String bianhao;	private String shebeimingcheng;	private String shenqingshuliang;	private String shenqingyuanyin;	private String shenqingren;	private String issh;	
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
    }	public String getShenqingshuliang() {
        return shenqingshuliang;
    }
    public void setShenqingshuliang(String shenqingshuliang) {
        this.shenqingshuliang = shenqingshuliang == null ? null : shenqingshuliang.trim();
    }	public String getShenqingyuanyin() {
        return shenqingyuanyin;
    }
    public void setShenqingyuanyin(String shenqingyuanyin) {
        this.shenqingyuanyin = shenqingyuanyin == null ? null : shenqingyuanyin.trim();
    }	public String getShenqingren() {
        return shenqingren;
    }
    public void setShenqingren(String shenqingren) {
        this.shenqingren = shenqingren == null ? null : shenqingren.trim();
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
