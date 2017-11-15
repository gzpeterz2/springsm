package com.hc.ssm.po;

import java.util.List;
import java.util.Map;

public class ItemsQueryVo {
	ItemsCustom itemsCustom;
	List<ItemsCustom> itemsList;
	Map<String, String> itemsInfo;

	public Map<String, String> getItemsInfo() {
		return itemsInfo;
	}

	public void setItemsInfo(Map<String, String> itemsInfo) {
		this.itemsInfo = itemsInfo;
	}

	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

	@Override
	public String toString() {
		return "ItemsQueryVo [itemsCustom=" + itemsCustom + "]";
	}
}
