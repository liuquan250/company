package com.train.bean;

public class Invest {
	private String uname;//�û���
	private float invest;//Ͷ�ʽ��
	private float gain;//������
	private float total;//��Ϣ�ϼ�
	private String investkind;//Ͷ������
	private int investtime;//Ͷ��ʱ��
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
