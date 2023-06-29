package com.example.officialgsmclientserver.domain.board.repository;

import com.example.officialgsmclientserver.domain.board.entity.post.Category;
import com.example.officialgsmclientserver.domain.board.entity.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAllByCategory(Pageable pageable, Category category);

    @Query("select p from PinnedPost pp join Post p on pp.pinnedSeq = p.postSeq where p.category = :category")
    List<Post> findPinnedPostByCategory(@Param("category") Category category);
}
