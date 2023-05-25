package com.example.officialgsmclientserver.domain.board.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostListResponse {

    private List<PostInfoDto> postList;
    private int totalPages;
}
