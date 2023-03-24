package com.example.noticeservice.entity;


import com.example.noticeservice.dto.NoticeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Notice {

    @Id
    @GeneratedValue(generator = "notice_seq")
    @SequenceGenerator(name = "notice_seq", sequenceName = "notice_seq")
    private Long id;
    private String title;
    private LocalDateTime time = LocalDateTime.now();
    private String body;
    private Long userId;

    public Notice(NoticeDTO noticeDTO) {
        this.title = noticeDTO.getTitle();
        this.body = noticeDTO.getBody();
        this.userId = noticeDTO.getUserId();
    }
}
