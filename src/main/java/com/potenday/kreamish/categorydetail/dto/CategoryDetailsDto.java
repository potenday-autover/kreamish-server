package com.potenday.kreamish.categorydetail.dto;

import com.potenday.kreamish.categorydetail.entity.CategoryDetail;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class CategoryDetailsDto {
    List<CategoryDetailDto> categoryDetailDtoList;

    public static CategoryDetailsDto of(List<CategoryDetail> categoryDetailList) {
        return new CategoryDetailsDto(categoryDetailList.stream()
                .map(CategoryDetailDto::of)
                .collect(Collectors.toList()));
    }
}
