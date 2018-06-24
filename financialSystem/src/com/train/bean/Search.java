package com.train.bean;

public class Search {
	private float price;  //商品单价
	private int number;  //商品数量
	private String cuspeople;//消费人
	private String cusplace; //消费地点
	private String paykind;//付款方式
	private String bussiness;//商家
	private String cuskind;//消费种类
	private String custime;//消费时间
	private String remark;//备注
	private String totalprice;//消费总价
	
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getCuspeople() {
		return cuspeople;
	}
	public void setCuspeople(String cuspeople) {
		this.cuspeople = cuspeople;
	}
	public String getCusplace() {
		return cusplace;
	}
	public void setCusplace(String cusplace) {
		this.cusplace = cusplace;
	}
	public String getPaykind() {
		return paykind;
	}
	public void setPaykind(String paykind) {
		this.paykind = paykind;
	}
	public String getBussiness() {
		return bussiness;
	}
	public void setBussiness(String bussiness) {
		this.bussiness = bussiness;
	}
	public String getCuskind() {
		return cuskind;
	}
	public void setCuskind(String cuskind) {
		this.cuskind = cuskind;
	}
	public String getCustime() {
		return custime;
	}
	public void setCustime(String custime) {
		this.custime = custime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Search [price=" + price + ", number=" + number + ", cuspeople=" + cuspeople + ", cusplace=" + cusplace
				+ ", paykind=" + paykind + ", bussiness=" + bussiness + ", cuskind=" + cuskind + ", custime=" + custime
				+ ", remark=" + remark + ", totalprice=" + totalprice + "]";
	}
	
	
}
