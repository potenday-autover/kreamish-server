package com.potenday.kreamish.filter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.potenday.kreamish.categorydetail.dto.CategoryDetailDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleCategoryDetailDto {

    @JsonProperty("category_detail_id")
    private Long id;
    @JsonProperty("category_detail_name")
    private String name;

    public static SimpleCategoryDetailDto of(CategoryDetailDto categoryDetailDto) {
        return new SimpleCategoryDetailDto(categoryDetailDto.getCategoryDetailId(),
            categoryDetailDto.getName());
    }
}
