package com.train.bean;

public class Invest {
	private String uname;//用户名
	private float invest;//投资金额
	private float gain;//纯利润
	private float total;//本息合计
	private String investkind;//投资类型
	private int investtime;//投资时长
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public float getInvest() {
		return invest;
	}
	public void setInvest(float invest) {
		this.invest = invest;
	}
	public float getGain() {
		return gain;
	}
	public void setGain(float gain) {
		this.gain = gain;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getInvestkind() {
		return investkind;
	}
	public void setInvestkind(String investkind) {
		this.investkind = investkind;
	}
	public int getInvesttime() {
		return investtime;
	}
	public void setInvesttime(int investtime) {
		this.investtime = investtime;
	}
	@Override
	public String toString() {
		return "Invest [uname=" + uname + ", invest=" + invest + ", gain=" + gain + ", total=" + total + ", investkind="
				+ investkind + ", investtime=" + investtime + "]";
	}
	
}
