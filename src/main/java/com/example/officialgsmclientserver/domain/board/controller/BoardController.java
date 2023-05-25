package com.example.officialgsmclientserver.domain.board.controller;

import com.example.officialgsmclientserver.domain.board.dto.response.PostDetailResponse;
import com.example.officialgsmclientserver.domain.board.dto.response.PostInfoDto;
import com.example.officialgsmclientserver.domain.board.entity.post.Category;
import com.example.officialgsmclientserver.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<Page<PostInfoDto>> postList(@RequestParam int pageNumber, @RequestParam Category category) {
        Page<PostInfoDto> postList = boardService.findPostList(pageNumber, category);
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @GetMapping("/{postSeq}")
    public ResponseEntity<PostDetailResponse> postDetail(@PathVariable Long postSeq) {
        PostDetailResponse postDetail = boardService.findPost(postSeq);
        return new ResponseEntity<>(postDetail, HttpStatus.OK);
    }
}
