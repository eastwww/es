package com.es.repository;

import com.es.entity.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * description : ItemRepository
 * Created by WangD.
 * Date 2020/3/26 15:25
 *  @Param:
 * 	Item:为实体类
 * 	Long:为Item实体类中主键的数据类型
 */
public interface ItemRepository extends ElasticsearchRepository<Item,Long> {

    //自定义方法，findBy规则
    Iterable<Item> findByTitle(String title);
}
