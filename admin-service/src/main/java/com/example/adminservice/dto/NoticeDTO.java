package com.example.adminservice.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class NoticeDTO {

    private String title;
    private String body;
    private Long userId;

}
