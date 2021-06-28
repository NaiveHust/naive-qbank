package com.naive.controller;

import com.naive.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YechenGu
 * @date 2021/6/28 3:47 下午
 */
@RestController
@RequestMapping("api/v1/problem")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping("find_by_id")
    public Object findById(@RequestParam("proId") int proId){
        return questionService.findById(proId);
    }

    // TODO: add,delete,update
}
