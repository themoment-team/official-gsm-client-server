package com.example.officialgsmclientserver.domain.popup.dto;

import com.example.officialgsmclientserver.domain.popup.entity.Popup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PopupInfoResponse {

    private String imageUrl;

    private String title;

    private String link;

    private LocalDateTime expirationDateTime;

    public static PopupInfoResponse from(Popup popup) {
        return PopupInfoResponse.builder()
                .imageUrl(popup.getPopupImageUrl())
                .title(popup.getPopupTitle())
                .link(popup.getPopupLink())
                .expirationDateTime(popup.getPopupExpirationDateTime())
                .build();
    }
}
