package com.es.service;

import com.es.entity.Item;

import java.util.List;

/**
 * description :
 * Created by WangD.
 * Date 2020/3/26 15:31
 */
public interface IItemService {
    void addItem(Item item);

    void addListItem(List<Item> list);

    Iterable<Item> queryAllItem();

    Iterable<Item> queryItemByTitle(String title);
}
