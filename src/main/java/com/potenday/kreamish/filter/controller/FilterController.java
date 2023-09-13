package com.potenday.kreamish.filter.controller;


import static com.potenday.kreamish.common.util.ApiUtils.success;

import com.potenday.kreamish.collection.dto.CollectionDto;
import com.potenday.kreamish.common.util.ApiUtils.ApiResult;
import com.potenday.kreamish.filter.dto.BrandFilterResponseDto;
import com.potenday.kreamish.filter.dto.CategoriesFilterResponseDto;
import com.potenday.kreamish.filter.dto.ItemSizesFilterResponseDto;
import com.potenday.kreamish.filter.facade.FilterFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/filter")
public class FilterController {

    private final FilterFacade filterFacade;

    @GetMapping("/categories")
    @Operation(
        summary = "카테고리 별 세부 카테고리 리스트 반환",
        description = "필터링을 위한 모든 카테고리 별 세부 카테고리 리스트 반환"
    )
    @ApiResponse(responseCode = "200", description = "필터링을 위한 리스트 정상 반환")
    public ResponseEntity<ApiResult<List<CategoriesFilterResponseDto>>> getCategories() {
        return new ResponseEntity<>(success(filterFacade.getCategories()), HttpStatus.OK);
    }

    @GetMapping(value = "/brand", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
        summary = "브랜드 리스트 반환",
        description = "필터링을 위한 모든 브랜드 리스트 반환"
    )
    @ApiResponse(responseCode = "200", description = "필터링을 위한 리스트 정상 반환")
    public ResponseEntity<ApiResult<List<BrandFilterResponseDto>>> getBrand() {
        return new ResponseEntity<>(success(filterFacade.getBrandFilterList()), HttpStatus.OK);
    }

    @GetMapping(value = "/collections", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
        summary = "컬렉션 리스트 반환",
        description = "필터링을 위한 모든 컬렉션 리스트 반환"
    )
    @ApiResponse(responseCode = "200", description = "필터링을 위한 리스트 정상 반환")
    public ResponseEntity<ApiResult<List<CollectionDto>>> getCollections() {
        return new ResponseEntity<>(success(filterFacade.getCollections()), HttpStatus.OK);
    }
}
