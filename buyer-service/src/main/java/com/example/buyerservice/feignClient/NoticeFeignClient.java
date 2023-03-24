package com.example.buyerservice.feignClient;


import com.example.buyerservice.dto.NoticeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient("notice-service")
public interface NoticeFeignClient {

    @GetMapping("/notice/users")
    List<NoticeDTO> getAllUserNotice(@RequestHeader("user-id") Long userId);
}
