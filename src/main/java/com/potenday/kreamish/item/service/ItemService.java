package com.potenday.kreamish.item.service;

import com.potenday.kreamish.item.dto.ItemDetailResponseDto;
import com.potenday.kreamish.item.dto.ItemListResponseDto;
import com.potenday.kreamish.item.dto.ItemListSearchCondition;
import com.potenday.kreamish.item.entity.Item;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface ItemService {

    ItemListResponseDto findItemsByCondition(ItemListSearchCondition condition,
                                             PageRequest pageRequest);

    ItemDetailResponseDto findItemById(Long itemId);

    Optional<Item> getItemById(Long itemId);

}