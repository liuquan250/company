package com.train.bean;

import javax.xml.crypto.Data;

public class Jizhang {
	private float price;  //��Ʒ����
	private int number;  //��Ʒ����
	private String cuspeople;//������
	private String cusplace; //���ѵص�
	private String paykind;//���ʽ
	private String bussiness;//�̼�
	private String cuskind;//��������
	private String custime;//����ʱ��
	private String remark;//��ע
	private String uname;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
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
		return "Jizhang [price=" + price + ", number=" + number + ", cuspeople=" + cuspeople + ", cusplace=" + cusplace
				+ ", paykind=" + paykind + ", bussiness=" + bussiness + ", cuskind=" + cuskind + ", custime=" + custime
				+ ", remark=" + remark + ", uname=" + uname + "]";
	}
	
	
}
