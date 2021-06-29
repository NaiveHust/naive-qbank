package com.naive.controller;

import com.naive.domain.Problem;
import com.naive.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * add problem via id
     * */
    @PostMapping("add")
    public int add(@RequestBody Problem problem){
        System.out.println(problem.toString());
        return questionService.add(problem);
    }

    /**
     * update problem via id
     * */
    @PostMapping("update_by_id")
    public int updateById(@RequestBody Problem problem){
        System.out.println(problem.toString());
        return questionService.updateById(problem);
    }

    /**
     * delete problem via id
     * */
    @RequestMapping("delete_by_id")
    public int deleteById(@RequestParam("proId") int proId){
        return questionService.deleteById(proId);
    }
}
