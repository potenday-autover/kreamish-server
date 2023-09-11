package com.potenday.kreamish.repository;

import com.potenday.kreamish.entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<Collection, Long>, ItemQueryRepository {
}
