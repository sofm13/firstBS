package com.entity;

public class Bumenguanli {
    private Integer id;
	private String bumenbianhao;	private String bumenmingcheng;	private String bumendianhua;	private String bumenchuanzhen;	private String bumenxinxi;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getBumenbianhao() {
        return bumenbianhao;
    }
    public void setBumenbianhao(String bumenbianhao) {
        this.bumenbianhao = bumenbianhao == null ? null : bumenbianhao.trim();
    }	public String getBumenmingcheng() {
        return bumenmingcheng;
    }
    public void setBumenmingcheng(String bumenmingcheng) {
        this.bumenmingcheng = bumenmingcheng == null ? null : bumenmingcheng.trim();
    }	public String getBumendianhua() {
        return bumendianhua;
    }
    public void setBumendianhua(String bumendianhua) {
        this.bumendianhua = bumendianhua == null ? null : bumendianhua.trim();
    }	public String getBumenchuanzhen() {
        return bumenchuanzhen;
    }
    public void setBumenchuanzhen(String bumenchuanzhen) {
        this.bumenchuanzhen = bumenchuanzhen == null ? null : bumenchuanzhen.trim();
    }	public String getBumenxinxi() {
        return bumenxinxi;
    }
    public void setBumenxinxi(String bumenxinxi) {
        this.bumenxinxi = bumenxinxi == null ? null : bumenxinxi.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
