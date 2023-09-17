package com.potenday.kreamish.comment.service;

import com.potenday.kreamish.comment.dto.CommentResponseDto;
import com.potenday.kreamish.comment.entity.Comment;
import com.potenday.kreamish.item.entity.Item;
import com.potenday.kreamish.member.entity.Member;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    Optional<Comment> create(Item item, Member member, String value);

    Optional<Comment> findById(Long commentId);

    void delete(Comment comment);

    Long getCommentCount(Long itemId);

    List<CommentResponseDto> getComments(Long itemId);
}
