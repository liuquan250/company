package com.train.bean;

public class Income {
	private String incomeKind;//��������
	private String income;//������
	private String uname;//�û���
	private String incometime;//����ʱ��
	public String getIncomeKind() {
		return incomeKind;
	}
	public void setIncomeKind(String incomeKind) {
		this.incomeKind = incomeKind;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getIncometime() {
		return incometime;
	}
	public void setIncometime(String incometime) {
		this.incometime = incometime;
	}
	@Override
	public String toString() {
		return "Income [incomeKind=" + incomeKind + ", income=" + income + ", uname=" + uname + ", incometime="
				+ incometime + "]";
	}
	
}
