package com.potenday.kreamish.favorite.repository;

import com.potenday.kreamish.favorite.enity.Favorite;
import com.potenday.kreamish.itemsizes.entity.ItemSizes;
import com.potenday.kreamish.member.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

}
