package com.train.service;

import java.sql.SQLException;

import com.train.bean.Income;
import com.train.dao.IncomeDao;

public class IncomeService {
	IncomeDao incomedao=new IncomeDao();
	public Income income(String uname,String income,String incomekind,String incometime) throws SQLException{
		return incomedao.income(uname, income, incomekind, incometime);
	}
}
