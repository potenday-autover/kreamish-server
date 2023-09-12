package com.potenday.kreamish.brand.service;

import com.potenday.kreamish.brand.dto.BrandDto;
import com.potenday.kreamish.brand.entity.Brand;
import com.potenday.kreamish.brand.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public List<BrandDto> getAllBrand() {
        List<Brand> allBrand = brandRepository.findAll();

        return allBrand.stream()
            .map(BrandDto::of)
            .collect(Collectors.toList());
    }
}
