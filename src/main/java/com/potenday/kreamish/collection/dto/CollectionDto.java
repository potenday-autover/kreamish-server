package com.potenday.kreamish.collection.dto;

import com.potenday.kreamish.collection.entity.Collection;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class CollectionDto {

    private final Long id;
    private final String name;

    public static CollectionDto of(Collection collection) {
        return new CollectionDto(collection.getCollectionId(), collection.getName());
    }
}
