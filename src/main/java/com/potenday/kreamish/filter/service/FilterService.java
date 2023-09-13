package com.potenday.kreamish.filter.service;

import com.potenday.kreamish.brand.dto.BrandDto;
import com.potenday.kreamish.filter.dto.BrandFilterResponseDto;
import com.potenday.kreamish.filter.dto.ItemSizesFilterResponseDto;
import java.util.List;

public interface FilterService {

    List<BrandFilterResponseDto> convertToBrandFilterList(List<BrandDto> allBrand);

}
