package com.potenday.kreamish.repository;

import com.potenday.kreamish.entity.ItemCollectionRel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCollectionRelRepository extends JpaRepository<ItemCollectionRel, Long>, ItemQueryRepository {
}
