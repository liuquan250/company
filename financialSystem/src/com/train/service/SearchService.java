package com.train.service;

import java.sql.SQLException;

import com.train.bean.Search;
import com.train.dao.SearchDao;

public class SearchService {
	SearchDao sd=new SearchDao();
	public Search se(String startDate,String endDate) throws SQLException{
		return sd.search(startDate, endDate);
	}
}
