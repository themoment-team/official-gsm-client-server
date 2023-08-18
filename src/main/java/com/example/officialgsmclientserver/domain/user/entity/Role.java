package com.example.officialgsmclientserver.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    MASTER("MASTER"),
    ADMIN("ADMIN"),
    UNAPPROVED("UNAPPROVED");

    private final String key;
}