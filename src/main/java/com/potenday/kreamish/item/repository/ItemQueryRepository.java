package com.potenday.kreamish.item.repository;

import com.potenday.kreamish.item.dto.ItemListSearchCondition;
import com.potenday.kreamish.item.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemQueryRepository {

    List<Item> findItemsWhereLikes(String name);

    Page<Item> findItemsByCondition(ItemListSearchCondition condition, Pageable pageable);

}
