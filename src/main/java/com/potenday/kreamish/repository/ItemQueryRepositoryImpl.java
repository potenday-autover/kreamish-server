package com.potenday.kreamish.repository;

import com.potenday.kreamish.entity.Item;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.potenday.kreamish.entity.QItem.item;

@RequiredArgsConstructor
public class ItemQueryRepositoryImpl implements ItemQueryRepository {

    private final JPAQueryFactory query;


    public List<Item> findItemsWhereLikes(String name){
        return query.select(item)
                .from(item)
                .where(item.name.like(name))
                .fetch();
    }
}