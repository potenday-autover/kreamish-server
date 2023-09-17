package com.potenday.kreamish.itemsizes.dto;

import com.potenday.kreamish.itemsizes.entity.ItemSizes;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class ItemSizeDto {

    private String size;
    private String category;

    public static ItemSizeDto of(ItemSizes itemSizes) {
        return new ItemSizeDto(itemSizes.getSize(), itemSizes.getItem().getCategory().getName());
    }
}
