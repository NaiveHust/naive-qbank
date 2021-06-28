package com.naive.controller;

import com.naive.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YechenGu
 * @date 2021/6/28 4:30 下午
 */
@RestController
@RequestMapping("api/v1/paper")
public class PaperController {
    @Autowired
    private PaperService paperService;

    //TODO: add, update, select, delete
}
