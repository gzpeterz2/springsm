package com.hc.ssm.service;

import java.sql.SQLException;
import java.util.List;

import com.hc.exception.CustomException;
import com.hc.ssm.po.Items;

public interface ItemsService {
	public List<Items> getItemsList() throws SQLException; 
	public Items findById(Integer id) throws SQLException, CustomException; 
	void save(Items items) throws SQLException; 
	void update(Integer id, Items items) throws SQLException; 
}
