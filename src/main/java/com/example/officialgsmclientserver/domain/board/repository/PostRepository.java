package com.example.officialgsmclientserver.domain.board.repository;

import com.example.officialgsmclientserver.domain.board.entity.post.Category;
import com.example.officialgsmclientserver.domain.board.entity.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAllByCategory(Pageable pageable, Category category);
    Page<Post> findAllByCategoryAndPostTitleContaining(Pageable pageable, Category category, String keyword);
}
