package com.train.bean;

public class Income {
	private String incomeKind;//收入类型
	private String income;//收入金额
	private String uname;//用户名
	private String incometime;//收入时间
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
