package com.potenday.kreamish.repository;


import com.potenday.kreamish.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long>, ItemQueryRepository {
}
