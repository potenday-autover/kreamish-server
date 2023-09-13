package com.potenday.kreamish.filter.facade;


import com.potenday.kreamish.brand.dto.BrandDto;
import com.potenday.kreamish.brand.service.BrandService;
import com.potenday.kreamish.category.dto.CategoryDto;
import com.potenday.kreamish.category.service.CategoryService;
import com.potenday.kreamish.categorydetail.dto.CategoryDetailDto;
import com.potenday.kreamish.categorydetail.service.CategoryDetailService;
import com.potenday.kreamish.collection.dto.CollectionDto;
import com.potenday.kreamish.collection.service.CollectionService;
import com.potenday.kreamish.filter.dto.BrandFilterResponseDto;
import com.potenday.kreamish.filter.dto.CategoriesFilterResponseDto;
import com.potenday.kreamish.filter.service.FilterService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
@Transactional(readOnly = true)
public class FilterFacade {

    private final CategoryService categoryService;
    private final CategoryDetailService categoryDetailService;
    private final BrandService brandService;
    private final CollectionService collectionService;
    private final FilterService filterService;

    public List<CategoriesFilterResponseDto> getCategories() {
        List<CategoryDto> categoryDtoList = categoryService.getAllCategories()
            .getCategoryDtoList();
        List<CategoryDetailDto> categoryDetailDtoList = categoryDetailService.getAllCategoryDetails()
            .getCategoryDetailDtoList();

        return categoryDtoList.stream()
            .map(categoryDto -> CategoriesFilterResponseDto.of(categoryDto, categoryDetailDtoList))
            .collect(Collectors.toList());
    }

    public List<BrandFilterResponseDto> getBrandFilterList() {
        List<BrandDto> allBrand = brandService.getAllBrand();

        return filterService.convertToBrandFilterList(allBrand);
    }

    public List<CollectionDto> getCollections() {
        return collectionService.getAllCollections();
    }

}
