package com.example.officialgsmclientserver.domain.board.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostListResponse {

    private List<PostInfoDto> postList;
    private int totalPages;
}
