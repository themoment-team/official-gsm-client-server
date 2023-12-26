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

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostInfoDto {

    private Long postSeq;
    private String postTitle;
    private String postWriter;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;
    private String thumbnailUrl;
    private String contentPreview;

    public static PostInfoDto from(Post post) {
        if(post.getCategory() == Category.EVENT_GALLERY) {
            return PostInfoDto.builder()
                    .postSeq(post.getPostSeq())
                    .postTitle(post.getPostTitle())
                    .postWriter(post.getUser().getUserName())
                    .createdAt(post.getCreatedAt())
                    .thumbnailUrl(post.getFiles().get(0).getFileUrl())
                    .contentPreview(extractContentPreview(post.getPostContent()))
                    .build();
        } else {
            return PostInfoDto.builder()
                    .postSeq(post.getPostSeq())
                    .postTitle(post.getPostTitle())
                    .postWriter(post.getUser().getUserName())
                    .createdAt(post.getCreatedAt())
                    .thumbnailUrl(null)
                    .contentPreview(extractContentPreview(post.getPostContent()))
                    .build();
        }
    }

    private static String extractContentPreview(String content) {
        return content.length() > 100 ? content.substring(0, 100) : content;
    }
}
