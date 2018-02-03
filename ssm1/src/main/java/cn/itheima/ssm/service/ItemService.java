package cn.itheima.ssm.service;

import java.util.List;

import org.springframework.ui.Model;

import cn.itheima.ssm.po.Item;

public interface ItemService {
	/**
	 * 查询所有商品信息
	 */
	List<Item> queryItemList();
	/**
	 * 根据ID查询商品
	 */
	Item queryItemById(Model model, Integer id);
	/**
	 * 修改item
	 * @param item
	 */
	void updateItem(Item item);
}
