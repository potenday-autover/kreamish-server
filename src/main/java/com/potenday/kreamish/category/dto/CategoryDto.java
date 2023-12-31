package com.potenday.kreamish.category.dto;

import com.potenday.kreamish.category.entity.Category;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class CategoryDto {
    private Long categoryId;
    private String name;

    public static CategoryDto of(Category category) {
        return new CategoryDto(category.getCategoryId(),category.getName());
    }
}
