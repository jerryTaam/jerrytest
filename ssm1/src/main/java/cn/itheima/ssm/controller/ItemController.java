package cn.itheima.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itheima.ssm.po.Item;
import cn.itheima.ssm.po.QueryVo;
import cn.itheima.ssm.service.ItemService;


@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	/**
	 * 查询所有商品
	 */
	@RequestMapping("/queryItem.do")
	public ModelAndView queryItem(QueryVo queryVo){
		// 1.创建modelandview对象
		ModelAndView mav = new ModelAndView();
		// 2.响应商品模型数据
		// 准备商品静态数据
		List<Item> items = itemService.queryItemList();
		
		mav.addObject("itemList",items);
		mav.setViewName("item/itemList");
		
		return mav;
	}
	@RequestMapping("/queryItemById.do")
	public String queryItemById(Model model,Integer id){
		
		Item item = itemService.queryItemById(null, id);
		model.addAttribute("item", item);
		
		return "item/itemEdit";
	}
	/**
	 * 修改商品数据，保存数据库
	 * 		http://127.0.0.1:8080/ssm/updateItem.do
	 */
	@RequestMapping("/updateItem.do")
	public String updateItem(Item item){
		try{
			// 1.保存商品数据
			this.itemService.updateItem(item);
		}catch(Exception e){
			e.printStackTrace();
			// 如果异常，提示用户操作失败
			return "common/failure";
		}
		
		// 如果成功，提示用户操作成功
		return "common/success";	
	}

}
