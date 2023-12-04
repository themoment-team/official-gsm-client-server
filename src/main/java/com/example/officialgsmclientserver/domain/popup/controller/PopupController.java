package com.example.officialgsmclientserver.domain.popup.controller;

import com.example.officialgsmclientserver.domain.popup.dto.PopupInfoResponse;
import com.example.officialgsmclientserver.domain.popup.service.PopupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/popup")
@RequiredArgsConstructor
public class PopupController {

    private final PopupService popupService;

    @GetMapping
    public ResponseEntity<List<PopupInfoResponse>> popupListFind() {
        List<PopupInfoResponse> popupInfoResponses = popupService.findPopupList();
        return new ResponseEntity<>(popupInfoResponses, HttpStatus.OK);
    }
}
