package com.example.officialgsmclientserver.domain.board.repository;

import com.example.officialgsmclientserver.domain.board.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
