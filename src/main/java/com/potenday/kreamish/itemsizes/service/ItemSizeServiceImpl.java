package com.potenday.kreamish.itemsizes.service;

import com.potenday.kreamish.itemsizes.dto.ItemSizeDto;
import com.potenday.kreamish.itemsizes.entity.ItemSizes;
import com.potenday.kreamish.itemsizes.repository.ItemSizesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemSizeServiceImpl implements ItemSizeService {

    private final ItemSizesRepository itemSizesRepository;

    // ToDo : N + 1 문제 발생하나 확인해보기.
    public List<ItemSizeDto> getItemSizes() {
        List<ItemSizes> allItemSizes = itemSizesRepository.findAll();

        return allItemSizes.stream()
            .map(itemSizes -> ItemSizeDto.of(itemSizes))
            .collect(Collectors.toSet()).stream()
            .collect(Collectors.toList());
    }
}
