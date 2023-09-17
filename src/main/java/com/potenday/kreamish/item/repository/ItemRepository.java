package com.potenday.kreamish.item.repository;

import com.potenday.kreamish.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>, ItemQueryRepository{

}
