package com.example.officialgsmclientserver.domain.popup.service;

import com.example.officialgsmclientserver.domain.popup.dto.PopupInfoResponse;
import com.example.officialgsmclientserver.domain.popup.entity.Popup;
import com.example.officialgsmclientserver.domain.popup.repository.PopupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PopupService {

    private final PopupRepository popupRepository;

    @Transactional(readOnly = true)
    public List<PopupInfoResponse> findPopupList() {
        List<Popup> popupList = popupRepository.findAll();
        return popupList.stream()
                .map(PopupInfoResponse::from).toList();
    }
}
