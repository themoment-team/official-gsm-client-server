package com.example.officialgsmclientserver.domain.board.dto.response;

import com.example.officialgsmclientserver.domain.board.entity.post.Category;
import com.example.officialgsmclientserver.domain.board.entity.post.Post;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDetailResponse {

    private String postTitle;
    private String postWriter;
    private String postContent;
    private Category category;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;
    private List<FileInfoResponse> fileInfo;

    public static PostDetailResponse from(Post post) {
        return PostDetailResponse.builder()
                .postTitle(post.getPostTitle())
                .postWriter(post.getUser().getUserName())
                .postContent(post.getPostContent())
                .category(post.getCategory())
                .createdAt(post.getCreatedAt())
                .fileInfo(post.getFiles().stream()
                        .map(FileInfoResponse::new)
                        .collect(Collectors.toList()))
                .build();
    }
}
