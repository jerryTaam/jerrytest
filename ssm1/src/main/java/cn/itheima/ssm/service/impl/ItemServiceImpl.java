package cn.itheima.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import cn.itheima.ssm.mapper.ItemMapper;
import cn.itheima.ssm.po.Item;
import cn.itheima.ssm.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMapper;
	public List<Item> queryItemList() {
		List<Item> list = this.itemMapper.selectByExample(null);
		
		return list;
	}

	public Item queryItemById(Model model, Integer id) {
		Item item = this.itemMapper.selectByPrimaryKey(id);
		return item;
	}

	public void updateItem(Item item) {
		this.itemMapper.updateByPrimaryKeySelective(item);
	}



}
