package com.potenday.kreamish.repository;

import com.potenday.kreamish.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>, ItemQueryRepository {
}
