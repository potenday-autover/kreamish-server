package com.potenday.kreamish.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDetailResponseDto {
    private String name;
    private String subName;
    private Long recentPrice;
    private String modelCode;
    private LocalDate releaseDate;
    private String representativeColor;
}
