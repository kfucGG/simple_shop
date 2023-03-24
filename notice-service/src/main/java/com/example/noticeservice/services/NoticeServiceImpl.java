package com.example.noticeservice.services;


import com.example.noticeservice.dto.NoticeDTO;
import com.example.noticeservice.entity.Notice;
import com.example.noticeservice.repositories.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    @Override
    @Transactional
    public void addNoticeToUser(NoticeDTO notice) {
        Notice userNotice = new Notice(notice);
        noticeRepository.save(userNotice);
    }

    @Override
    public List<Notice> getUserNotice(Long userId) {
        return noticeRepository.findAllByUserId(userId);
    }
}
