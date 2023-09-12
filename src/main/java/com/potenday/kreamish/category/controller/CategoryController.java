package com.potenday.kreamish.category.controller;

import static com.potenday.kreamish.common.util.ApiUtils.success;

import com.potenday.kreamish.category.dto.CategoriesDto;
import com.potenday.kreamish.category.service.CategoryService;
import com.potenday.kreamish.common.util.ApiUtils.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    @Operation(
        summary = "모든 category list",
        description = "모든 category list를 반환"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "category list no content"),
        @ApiResponse(responseCode = "200", description = "category list 정상 반환"),
        @ApiResponse(responseCode = "404", description = "category service error",content = @Content)
    })
    public ResponseEntity<ApiResult<?>> getItems() {
        CategoriesDto findCategories = categoryService.getAllCategories();
        HttpStatus httpStatus = findCategories.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;

        return new ResponseEntity<>(success(findCategories), httpStatus);
    }
}
