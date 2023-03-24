package com.example.noticeservice.services;

import com.example.noticeservice.dto.NoticeDTO;
import com.example.noticeservice.entity.Notice;

import java.util.List;


public interface NoticeService {


    void addNoticeToUser(NoticeDTO notice);

    List<Notice> getUserNotice(Long userId);
}
