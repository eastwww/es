package com.es.controller;

import com.es.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description : es
 * Created by WangD.
 * Date 2020/3/26 11:51
 */
@RestController
public class ElasticsearchController {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 创建es索引,此操作可在es-head中完成
     */
    @RequestMapping("/createIndex")
    public String createIndex(){
        elasticsearchTemplate.createIndex(Item.class);
        elasticsearchTemplate.putMapping(Item.class);
        return "create-index : success!";
    }

    /**
     * 删除es索引,此操作可在es-head中完成
     */
    @RequestMapping("/deleteIndex")
    public String deleteIndex(){
        elasticsearchTemplate.deleteIndex(Item.class);
        return "delete-index : success!";
    }
}
