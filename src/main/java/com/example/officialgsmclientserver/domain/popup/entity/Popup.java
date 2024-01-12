package com.example.officialgsmclientserver.domain.popup.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Popup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "popup_seq")
    private Long popupSeq;

    @Column(name = "popup_image_url", nullable = false)
    private String popupImageUrl;

    @Column(name = "popup_title", nullable = false)
    private String popupTitle;

    @Column(name = "popup_link", nullable = true)
    private String popupLink;

    @Column(name = "popup_expiration_date_time", nullable = false)
    private LocalDateTime popupExpirationDateTime;
}
