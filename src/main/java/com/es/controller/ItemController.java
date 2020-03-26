package com.es.controller;

import com.es.entity.Item;
import com.es.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * description : 商品
 * Created by WangD.
 * Date 2020/3/26 15:28
 */
@RestController
public class ItemController {

    @Autowired
    private IItemService itemService;

    @RequestMapping("addItem")
    public String addItem(){
        Item item = new Item(1L, "小米手机7", " 手机",
                "小米", 3499.00, "http://file01.netvan.cn/wap/styres/files/20200218/8a2d97977058a49e017058a63d6c0007.png");
        itemService.addItem(item);
        return "add-success";
    }

    @RequestMapping("addListItem")
    public String addListItem(){
        List<Item> list = new ArrayList<Item>();
        list.add( new Item(2L, "西瓜手机", " 手机","西瓜", 2222.00, "http://file01.netvan.cn/wap/styres/files/20200218/8a2d97977058a49e017058a63d6c0007.png"));
        list.add( new Item(3L, "苹果手机7", " 平板","苹果", 7888.00, "http://file01.netvan.cn/wap/styres/files/20200218/8a2d97977058a49e017058a63d6c0007.png"));
        itemService.addListItem(list);
        return "addList-success";
    }

    @RequestMapping("updateItem")
    public String updateItem(){
        //修改和新增是同一个接口，区分的依据就是id
        Item item = new Item(1L, "苹果XSMax", " 手机",
                "小米", 9999.00, "http://image.baidu.com/13123.jpg");
        itemService.addItem(item);
        return "update-success";
    }

    @RequestMapping("queryAllItem")
    public String queryAllItem(){
        Iterable<Item> list = itemService.queryAllItem();
        for (Item item:list){
            System.out.println(item);
        }
        return "queryAll-success";
    }

    @RequestMapping("queryItemByTitle/{title}")
    public String queryItemByTitle(@PathVariable String title){
        Iterable<Item> list = itemService.queryItemByTitle(title);
        for (Item item:list){
            System.out.println(item);
        }
        return "queryItemByTitle-success";
    }




}
