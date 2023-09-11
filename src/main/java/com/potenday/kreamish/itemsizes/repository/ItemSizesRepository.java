package com.potenday.kreamish.itemsizes.repository;

import com.potenday.kreamish.itemsizes.entity.ItemSizes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemSizesRepository extends JpaRepository<ItemSizes, Long> {

}
