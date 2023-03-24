package com.example.buyerservice.controllers;


import com.example.buyerservice.dto.NoticeDTO;
import com.example.buyerservice.feignClient.NoticeFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/buyer/notice")
@RequiredArgsConstructor
public class BuyerNoticeController {

    private final NoticeFeignClient noticeClient;

    @GetMapping
    public List<NoticeDTO> getUserNotice(@RequestHeader("user-id") Long userId) {
        return noticeClient.getAllUserNotice(userId);
    }
}
