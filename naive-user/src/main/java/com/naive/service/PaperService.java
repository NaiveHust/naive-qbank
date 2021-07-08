package com.naive.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author YechenGu
 * @date 2021/7/8 9:44 上午
 */
@FeignClient("naive-paper")
public interface PaperService {

    @GetMapping("api/v1/paper/deleteByTea/{tid}")
    int deleteByTea(@PathVariable("tid") int tid);
}
