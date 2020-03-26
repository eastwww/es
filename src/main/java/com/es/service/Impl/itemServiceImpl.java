package com.es.service.Impl;

import com.es.entity.Item;
import com.es.repository.ItemRepository;
import com.es.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description :
 * Created by WangD.
 * Date 2020/3/26 15:32
 */
@Service
public class itemServiceImpl implements IItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void addItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void addListItem(List<Item> list) {
        // 接收对象集合，实现批量新增
        itemRepository.saveAll(list);
    }

    @Override
    public Iterable<Item> queryAllItem() {
        // 查找所有
        //Iterable<Item> list = this.itemRepository.findAll();
        // 对某字段排序查找所有 Sort.by("price").descending() 降序
        // Sort.by("price").ascending():升序
        Iterable<Item> list = this.itemRepository.findAll(Sort.by("price").ascending());
        return list;
    }

    @Override
    public Iterable<Item> queryItemByTitle(String title) {
        Iterable<Item> list = itemRepository.findByTitle(title);
        return list;
    }
}
