package com.potenday.kreamish.filter.service;


import com.potenday.kreamish.brand.dto.BrandDto;
import com.potenday.kreamish.filter.dto.BrandFilterResponseDto;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
@Transactional
public class FilterServiceImpl implements FilterService {

    @Override
    public List<BrandFilterResponseDto> convertToBrandFilterList(List<BrandDto> allBrand) {
        Map<Character, BrandFilterResponseDto> firstLetter2BrandFilterResponseDto = getFirstLetter2BrandFilter(
            allBrand);

        return firstLetter2BrandFilterResponseDto
            .values()
            .stream()
            .sorted(Comparator.comparing(BrandFilterResponseDto::getBrandFirstLetter))
            .collect(Collectors.toList());
    }

    private Map<Character, BrandFilterResponseDto> getFirstLetter2BrandFilter(
        List<BrandDto> allBrand) {
        Map<Character, BrandFilterResponseDto> firstLetter2BrandFilterResponseDto = new HashMap<>();

        for (BrandDto brandDto : allBrand) {
            Character firstLetter = brandDto.getFirstLetter();

            addBrandOrDefault(firstLetter2BrandFilterResponseDto, brandDto, firstLetter);
        }
        return firstLetter2BrandFilterResponseDto;
    }

    private void addBrandOrDefault(
        Map<Character, BrandFilterResponseDto> firstLetter2BrandFilterResponseDto,
        BrandDto brandDto, Character firstLetter) {
        if (firstLetter2BrandFilterResponseDto.containsKey(firstLetter)) {
            firstLetter2BrandFilterResponseDto
                .get(firstLetter)
                .getBrandDtoList()
                .add(brandDto);
        } else {
            firstLetter2BrandFilterResponseDto.put(firstLetter,
                BrandFilterResponseDto.of(firstLetter, brandDto));
        }
    }
}
