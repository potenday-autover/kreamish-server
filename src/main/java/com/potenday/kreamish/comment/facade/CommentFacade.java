package com.potenday.kreamish.comment.facade;

import com.potenday.kreamish.comment.dto.CommentRequestDto;
import com.potenday.kreamish.comment.dto.CommentResponseDto;
import com.potenday.kreamish.comment.entity.Comment;
import com.potenday.kreamish.comment.service.CommentService;
import com.potenday.kreamish.item.entity.Item;
import com.potenday.kreamish.item.service.ItemService;
import com.potenday.kreamish.member.entity.Member;
import com.potenday.kreamish.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Component
public class CommentFacade {

    private final ItemService itemService;
    private final MemberService memberService;
    private final CommentService commentService;

    @Transactional
    public CommentResponseDto create(CommentRequestDto commentRequestDto) {
        Member member = memberService.getMemberById(commentRequestDto.getMemberId())
            .orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        Item item = itemService.getItemById(commentRequestDto.getItemId())
            .orElseThrow(() -> new IllegalArgumentException("Item Not Found"));

        return commentService.create(item, member, commentRequestDto.getContent())
            .map(CommentResponseDto::of)
            .orElseThrow(() -> new IllegalArgumentException("JPA Save Exception"));
    }

    @Transactional
    public void delete(Long commentId, Long memberId) {
        Comment comment = commentService.findById(commentId)
            .orElseThrow(() -> new NoSuchElementException("Comment Not Found"));

        if (!comment.isBelongTo(memberId)) {
            throw new IllegalArgumentException("Comment that does not belong to the Member");
        }

        commentService.delete(comment);
    }


    public Long getCommentCount(Long itemId) {
        return commentService.getCommentCount(itemId);
    }

    public List<CommentResponseDto> getComments(Long itemId) {
        Optional.ofNullable(itemService.findItemById(itemId))
            .orElseThrow(() -> new NoSuchElementException("Item Not Found"));

        return commentService.getComments(itemId);
    }
}