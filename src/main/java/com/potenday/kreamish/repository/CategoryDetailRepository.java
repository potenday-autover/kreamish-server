package com.potenday.kreamish.repository;

import com.potenday.kreamish.entity.CategoryDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDetailRepository extends JpaRepository<CategoryDetail, Long>, ItemQueryRepository {
}
