package com.potenday.kreamish.comment.service;

import com.potenday.kreamish.comment.dto.CommentResponseDto;
import com.potenday.kreamish.comment.entity.Comment;
import com.potenday.kreamish.comment.repository.CommentRepository;
import com.potenday.kreamish.item.entity.Item;
import com.potenday.kreamish.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Optional<Comment> create(Item item, Member member, String value) {
        return Optional.of(commentRepository.save(Comment.of(item, member, value)));
    }

    public Optional<Comment> findById(Long commentId) {
        return commentRepository.findById(commentId);
    }

    @Transactional
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    public Long getCommentCount(Long itemId) {
        List<Comment> all = commentRepository.findAll();
        System.out.println(all);
        return commentRepository.countByItemItemId(itemId);
    }

    public List<CommentResponseDto> getComments(Long itemId) {
        return commentRepository.findAllByItemItemId(itemId).stream()
            .map(CommentResponseDto::of)
            .collect(Collectors.toList());
    }
}