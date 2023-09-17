package com.potenday.kreamish.comment.repository;


import com.potenday.kreamish.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Long countByItemItemId(Long itemId);

    List<Comment> findAllByItemItemId(Long itemId);

}
