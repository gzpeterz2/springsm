package som.hc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hc.ssm.mapper.ItemsMapper;
import com.hc.ssm.po.Items;
import com.hc.ssm.po.ItemsExample;
import com.hc.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> getItemsList() {
		List<Items> list = null;
		ItemsExample example = new ItemsExample();
		ItemsExample.Criteria critera = example.createCriteria();
		
		list = itemsMapper.selectByExampleWithBLOBs(example);

		return list;
	}

}
