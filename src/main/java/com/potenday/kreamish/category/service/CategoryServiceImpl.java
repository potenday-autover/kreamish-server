package com.potenday.kreamish.category.service;

import com.potenday.kreamish.category.dto.CategoriesDto;
import com.potenday.kreamish.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public CategoriesDto getAllCategories() {
        return CategoriesDto.of(categoryRepository.findAll());
    }
}
