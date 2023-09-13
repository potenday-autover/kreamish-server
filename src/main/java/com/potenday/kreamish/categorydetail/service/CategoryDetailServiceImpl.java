package com.potenday.kreamish.categorydetail.service;

import com.potenday.kreamish.categorydetail.dto.CategoryDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.potenday.kreamish.categorydetail.repository.CategoryDetailRepository;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryDetailServiceImpl implements CategoryDetailService {

    private final CategoryDetailRepository categoryDetailRepository;

    public CategoryDetailsDto getAllCategoryDetails() {
        return CategoryDetailsDto.of(categoryDetailRepository.findAll());
    }
}
