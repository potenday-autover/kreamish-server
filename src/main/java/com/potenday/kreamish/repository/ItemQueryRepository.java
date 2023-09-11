package com.potenday.kreamish.repository;

import com.potenday.kreamish.entity.Item;

import java.util.List;

public interface ItemQueryRepository {
    List<Item> findItemsWhereLikes(String name);
}
