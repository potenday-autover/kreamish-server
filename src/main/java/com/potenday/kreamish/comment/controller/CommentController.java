package com.potenday.kreamish.comment.controller;

import com.potenday.kreamish.comment.dto.CommentRequestDto;
import com.potenday.kreamish.comment.dto.CommentResponseDto;
import com.potenday.kreamish.comment.dto.ItemCommentCountDto;
import com.potenday.kreamish.comment.facade.CommentFacade;
import com.potenday.kreamish.common.util.ApiUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.potenday.kreamish.common.util.ApiUtils.success;


@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentFacade commentFacade;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
        summary = "댓글 등록",
        description = "유저가 아이템에 댓글 등록"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "댓글 등록 성공"),
        @ApiResponse(responseCode = "400", description = "댓글 등록 실패")
    })
    public ResponseEntity<ApiUtils.ApiResult<CommentResponseDto>> createComment(
        @RequestBody @Valid CommentRequestDto commentRequestDto) {
        return new ResponseEntity<>(success(commentFacade.create(commentRequestDto)),
            HttpStatus.OK);
    }

    @DeleteMapping(value = "/{comment-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
        summary = "댓글 삭제",
        description = "유저가 아이템에 등록한 댓글을 삭제"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "댓글 삭제 성공"),
        @ApiResponse(responseCode = "400", description = "댓글 삭제 실패")
    })
    public ResponseEntity<ApiUtils.ApiResult<?>> deleteComment(
        @PathVariable("comment-id") Long commentId,
        // ToDo : basic token header
        @RequestParam("member-id") Long memberId) {

        commentFacade.delete(commentId, memberId);
        return new ResponseEntity<>(success(null), HttpStatus.OK);
    }

    @GetMapping(value = "/count/item/{item-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
        summary = "댓글 개수 가져오기",
        description = "특정 아이템에 등록된 댓글 개수 가져오기"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "댓글 개수 가져오기 성공"),
        @ApiResponse(responseCode = "400", description = "댓글 개수 가져오기 실패"),
        @ApiResponse(responseCode = "404", description = "존재하지 않는 아이템")
    })
    public ResponseEntity<ApiUtils.ApiResult<ItemCommentCountDto>> getCommentCount(
        @PathVariable("item-id") Long itemId) {
        Long commentCount = commentFacade.getCommentCount(itemId);
        ItemCommentCountDto itemCommentCountDto = ItemCommentCountDto.of(itemId, commentCount);

        return new ResponseEntity<>(success(itemCommentCountDto), HttpStatus.OK);
    }

    @GetMapping(value = "/item/{item-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
        summary = "댓글 전체 가져오기",
        description = "특정 아이템에 등록된 댓글 전체 댓글 가져오기"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "댓글 전체 가져오기 성공"),
        @ApiResponse(responseCode = "400", description = "댓글 전체 가져오기 실패"),
        @ApiResponse(responseCode = "404", description = "존재하지 않는 아이템")
    })
    public ResponseEntity<ApiUtils.ApiResult<List<CommentResponseDto>>> getComments(
        @PathVariable("item-id") Long itemId) {
        List<CommentResponseDto> commentsResponseDtoList = commentFacade.getComments(itemId);

        return new ResponseEntity<>(success(commentsResponseDtoList), HttpStatus.OK);
    }
}