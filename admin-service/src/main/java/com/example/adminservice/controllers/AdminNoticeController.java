package com.example.adminservice.controllers;


import com.example.adminservice.dto.NoticeDTO;
import com.example.adminservice.feignClients.NoticeFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/notice")
@RequiredArgsConstructor
public class AdminNoticeController {

    private final NoticeFeignClient noticeClient;

    @PostMapping
    public HttpStatus addNoticeToUser(@RequestBody NoticeDTO notice) {
        return noticeClient.addNoticeToUser(notice);
    }
}
