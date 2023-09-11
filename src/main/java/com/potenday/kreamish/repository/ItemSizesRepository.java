package com.potenday.kreamish.repository;

import com.potenday.kreamish.entity.ItemSizes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemSizesRepository extends JpaRepository<ItemSizes, Long>, ItemQueryRepository {
}
