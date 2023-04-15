package com.example.officialgsmclientserver.domain.board.service;

import com.example.officialgsmclientserver.domain.board.dto.response.PostDetailResponse;
import com.example.officialgsmclientserver.domain.board.dto.response.PostListResponse;
import com.example.officialgsmclientserver.domain.board.entity.post.Category;
import com.example.officialgsmclientserver.domain.board.entity.post.Post;
import com.example.officialgsmclientserver.domain.board.repository.PostRepository;
import com.example.officialgsmclientserver.global.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final PostRepository postRepository;

    public Page<PostListResponse> findPosts(int pageNumber, Category category) {
        Pageable pageable = PageRequest.of(pageNumber, 5, Sort.by("createdAt").descending());   // pageSize는 추후 수정
        Page<Post> posts = postRepository.findAllByCategory(pageable, category);

        return posts.map(PostListResponse::from);
    }

    public PostDetailResponse findPost(Long postSeq) {
        Post post = postRepository.findById(postSeq)
                .orElseThrow(() -> new CustomException("게시글 세부 조회 과정에서 게시글을 찾지 못하였습니다.", HttpStatus.NOT_FOUND));

        return PostDetailResponse.from(post);
    }
}
