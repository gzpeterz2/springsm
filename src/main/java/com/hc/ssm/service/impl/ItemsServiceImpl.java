package com.hc.ssm.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.hc.ssm.mapper.ItemsMapper;
import com.hc.ssm.mapper.UserMapper;
import com.hc.ssm.po.Items;
import com.hc.ssm.po.ItemsExample;
import com.hc.ssm.po.User;
import com.hc.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsMapper itemsMapper;

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<Items> getItemsList() throws SQLException {
		List<Items> list = null;
		ItemsExample example = new ItemsExample();
		ItemsExample.Criteria critera = example.createCriteria();
		
		list = itemsMapper.selectByExampleWithBLOBs(example);

		return list;
	}

	@Override
	public Items findById(Integer id) throws SQLException {
		Items items = itemsMapper.selectByPrimaryKey(id);
		if (items != null) {
			return items;
		} else {
			System.out.println("can not find item id is " + id);
			return null;
		}
	}
	public void save(Items items) throws SQLException {
		if (items == null) {
			// do something
			System.out.println("the items is null in save");
		}
		itemsMapper.insert(items);
	}

	@Override
	public void update(Integer id, Items items) throws SQLException {
		if (id != items.getId()) {
			System.out.println(items);
		}
		items.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
}
