package com.potenday.kreamish.item.repository;

import com.potenday.kreamish.trade.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Long> {

    @Query("select t from Trade t join fetch t.sale s join fetch s.itemSizes i "
        + "where i.itemSizesId in :itemSizesIds")
    List<Trade> findTradeByItemSizesIdList(List<Long> itemSizesIds);
}
