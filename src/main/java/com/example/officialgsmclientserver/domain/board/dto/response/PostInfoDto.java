package com.example.officialgsmclientserver.domain.board.dto.response;

import com.example.officialgsmclientserver.domain.board.entity.post.Category;
import com.example.officialgsmclientserver.domain.board.entity.post.Post;
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
    private LocalDateTime createdAt;
    private Boolean FileIsExist;
    private String bannerUrl;

    public static PostInfoDto from(Post post) {
        if(post.getCategory() == Category.EVENT_GALLERY) {
            return PostInfoDto.builder()
                    .postSeq(post.getPostSeq())
                    .postTitle(post.getPostTitle())
                    .createdAt(post.getCreatedAt())
                    .bannerUrl(post.getFiles().get(0).getFileUrl())
                    .postWriter(null)
                    .FileIsExist(null)
                    .build();
        } else {
            return PostInfoDto.builder()
                    .postSeq(post.getPostSeq())
                    .postTitle(post.getPostTitle())
                    .postWriter(post.getUser().getUserName())
                    .FileIsExist(post.getFiles()!=null)
                    .createdAt(post.getCreatedAt())
                    .bannerUrl(null)
                    .build();
        }
    }
}
