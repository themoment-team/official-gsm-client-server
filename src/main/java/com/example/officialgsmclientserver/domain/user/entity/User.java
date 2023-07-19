package com.example.officialgsmclientserver.domain.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_seq")
    private Long userSeq;

    private String oauthId;

    private String userName;

    private String userEmail;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    @JoinColumn(name = "grantor_seq", referencedColumnName = "user_seq")
    private User grantor;

    private LocalDateTime approvedAt;
}
