package com.example.officialgsmclientserver.domain.board.entity.post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PinnedPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pinned_seq")
    private Long pinnedSeq;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_seq", nullable = false)
    private Post post;
}
