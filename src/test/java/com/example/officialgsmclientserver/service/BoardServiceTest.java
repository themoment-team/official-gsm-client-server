package com.example.officialgsmclientserver.service;

import com.example.officialgsmclientserver.domain.board.dto.response.PostDetailResponse;
import com.example.officialgsmclientserver.domain.board.dto.response.PostListResponse;
import com.example.officialgsmclientserver.domain.board.entity.file.File;
import com.example.officialgsmclientserver.domain.board.entity.file.FileExtension;
import com.example.officialgsmclientserver.domain.board.entity.post.Category;
import com.example.officialgsmclientserver.domain.board.entity.post.Post;
import com.example.officialgsmclientserver.domain.board.repository.FileRepository;
import com.example.officialgsmclientserver.domain.board.repository.PostRepository;
import com.example.officialgsmclientserver.domain.board.service.BoardService;
import com.example.officialgsmclientserver.domain.user.entity.Role;
import com.example.officialgsmclientserver.domain.user.entity.User;
import com.example.officialgsmclientserver.domain.user.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
public class BoardServiceTest {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private BoardService boardService;

    @BeforeEach
    void setUp() {
        User user = User.builder()
                .oauthId("1234567")
                .userName("최장우")
                .userEmail("s22018@gsm.hs.kr")
                .role(Role.ADMIN)
                .approvedAt(LocalDateTime.now())
                .build();

        userRepository.save(user);

        em.flush();
        em.clear();

        for (int i=0; i<7; i++) {
            Post post = Post.builder()
                    .postTitle("title")
                    .postContent("content")
                    .category(Category.EVENT_GALLERY)
                    .files(List.of())
                    .user(user)
                    .build();

            postRepository.save(post);

            File file = File.builder()
                    .fileUrl("http://bucket.ottokeng.site/743d7afd-690c-404a-b7fb-b6fe97598504.jpg")
                    .fileName("file_name")
                    .fileExtension(FileExtension.JPG)
                    .post(post)
                    .build();

            fileRepository.save(file);

            em.flush();
            em.clear();
        }
    }

    @Test
    @DisplayName("게시물 목록 조회")
    void findPostList() {
        PostListResponse response = boardService.findPostList(0, Category.EVENT_GALLERY);

        assertThat(response.getPostList().get(0).getPostTitle()).isEqualTo("title");
        assertThat(response.getPostList().get(0).getThumbnailUrl()).isEqualTo(fileRepository.findAll().get(0).getFileUrl());
        assertThat(response.getPostList().get(0).getPostWriter()).isEqualTo("최장우");
        assertThat(response.getTotalPages()).isEqualTo(2);
    }

    @Test
    @DisplayName("게시물 상세 조회")
    void findPost() {
        Post post = postRepository.findAll().get(0);
        System.out.println(post.getPostSeq());
        PostDetailResponse response = boardService.findPost(post.getPostSeq());

        assertThat(response.getPostTitle()).isEqualTo("title");
        assertThat(response.getPostWriter()).isEqualTo("최장우");
        assertThat(response.getFileInfo().get(0).getFileUrl()).isEqualTo("http://bucket.ottokeng.site/743d7afd-690c-404a-b7fb-b6fe97598504.jpg");
        assertThat(response.getFileInfo().get(0).getFileExtension()).isEqualTo(FileExtension.JPG);
    }
}
