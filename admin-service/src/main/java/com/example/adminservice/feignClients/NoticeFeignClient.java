package com.example.adminservice.feignClients;


import com.example.adminservice.dto.NoticeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notice-service")
public interface NoticeFeignClient {

    @PostMapping("/notice/admin/add")
    HttpStatus addNoticeToUser(@RequestBody NoticeDTO noticeDTO);
}
