package com.entity;

public class Baofeishenqing {
    private Integer id;
	private String bianhao;	private String shebeimingcheng;	private String baofeiyuanyin;	private String baofeishuliang;	private String baofeiren;	private String issh;	
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
    }	public String getBaofeiyuanyin() {
        return baofeiyuanyin;
    }
    public void setBaofeiyuanyin(String baofeiyuanyin) {
        this.baofeiyuanyin = baofeiyuanyin == null ? null : baofeiyuanyin.trim();
    }	public String getBaofeishuliang() {
        return baofeishuliang;
    }
    public void setBaofeishuliang(String baofeishuliang) {
        this.baofeishuliang = baofeishuliang == null ? null : baofeishuliang.trim();
    }	public String getBaofeiren() {
        return baofeiren;
    }
    public void setBaofeiren(String baofeiren) {
        this.baofeiren = baofeiren == null ? null : baofeiren.trim();
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
