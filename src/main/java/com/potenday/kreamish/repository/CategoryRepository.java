package com.potenday.kreamish.repository;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>, ItemQueryRepository {
}
