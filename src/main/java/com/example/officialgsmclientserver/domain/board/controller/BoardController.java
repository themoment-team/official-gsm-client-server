package com.example.officialgsmclientserver.domain.board.controller;

import com.example.officialgsmclientserver.domain.board.dto.response.PostDetailResponse;
import com.example.officialgsmclientserver.domain.board.dto.response.PostListResponse;
import com.example.officialgsmclientserver.domain.board.entity.post.Category;
import com.example.officialgsmclientserver.domain.board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    @Operation(
            summary = "게시물 목록 조회 요청",
            description = "게시물 목록을 조회하는 api",
            tags = {"Board Controller"}
    )
    public ResponseEntity<PostListResponse> postList(
            @Parameter(name = "pageNumber", description = "게시물 목록의 pageNumber, 0부터 시작", in = ParameterIn.PATH)
            @RequestParam int pageNumber,
            @Parameter(name = "category", description = "조회할 게시물 목록의 카테고리", in = ParameterIn.PATH)
            @RequestParam Category category
    ) {
        PostListResponse postList = boardService.findPostList(pageNumber, category);
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @GetMapping("/{postSeq}")
    @Operation(
            summary = "게시물 상세 조회 요청",
            description = "게시물을 상세 조회하는 api",
            tags = {"Board Controller"}
    )
    public ResponseEntity<PostDetailResponse> postDetail(
            @Parameter(name = "postSeq", description = "게시물의 seq값", in = ParameterIn.PATH)
            @PathVariable Long postSeq
    ) {
        PostDetailResponse postDetail = boardService.findPost(postSeq);
        return new ResponseEntity<>(postDetail, HttpStatus.OK);
    }
}
