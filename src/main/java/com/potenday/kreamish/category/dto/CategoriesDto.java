package com.potenday.kreamish.category.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.stream.Collectors;

import com.potenday.kreamish.category.entity.Category;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class CategoriesDto {

    @JsonProperty(value = "categories")
    List<CategoryDto> categoryDtoList;

    public static CategoriesDto of(List<Category> categories) {
        return new CategoriesDto(categories.stream()
            .map(CategoryDto::of)
            .collect(Collectors.toList()));
    }

    public boolean isEmpty() {
        return categoryDtoList.isEmpty();
    }
}
