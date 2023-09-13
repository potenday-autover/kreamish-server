package com.potenday.kreamish.categorydetail.dto;


import com.potenday.kreamish.category.dto.CategoryDto;
import com.potenday.kreamish.categorydetail.entity.CategoryDetail;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class CategoryDetailDto {
    private Long categoryDetailId;
    private String name;
    private CategoryDto categoryDto;

    public static CategoryDetailDto of(CategoryDetail categoryDetail) {
        return new CategoryDetailDto(categoryDetail.getCategoryDetailId(), categoryDetail.getName(), CategoryDto.of(categoryDetail.getCategory()));
    }

    public boolean isBelongTo(CategoryDto categoryDto) {
        return this.categoryDto.getCategoryId().equals(categoryDto.getCategoryId());
    }
}
