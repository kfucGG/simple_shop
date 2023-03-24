package com.example.noticeservice.controllers;


import com.example.noticeservice.dto.NoticeDTO;
import com.example.noticeservice.services.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notice/users")
@RequiredArgsConstructor
public class NoticeUserController {

    private final NoticeService noticeService;


    @GetMapping
    public List<NoticeDTO> getAllUserNotice(@RequestHeader("user-id") Long userId) {
        return noticeService.getUserNotice(userId)
                .stream().map(NoticeDTO::new).collect(Collectors.toList());
    }
}
