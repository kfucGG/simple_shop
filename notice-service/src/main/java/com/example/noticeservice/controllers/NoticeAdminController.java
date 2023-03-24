package com.example.noticeservice.controllers;


import com.example.noticeservice.dto.NoticeDTO;
import com.example.noticeservice.services.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice/admin")
@RequiredArgsConstructor
public class NoticeAdminController {

    private final NoticeService noticeService;

    @PostMapping("/add")
    public HttpStatus addNoticeToUser(@RequestBody NoticeDTO noticeDTO) {
        noticeService.addNoticeToUser(noticeDTO);
        return HttpStatus.OK;
    }
}
