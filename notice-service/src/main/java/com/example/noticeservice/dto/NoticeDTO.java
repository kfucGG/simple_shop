package com.example.noticeservice.dto;


import com.example.noticeservice.entity.Notice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class NoticeDTO {

    private String title;
    private String body;
    private Long userId;

    public NoticeDTO(Notice notice) {
        this.title = notice.getTitle();
        this.body = notice.getBody();
        this.userId = notice.getUserId();
    }
}
