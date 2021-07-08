package com.naive.controller;

import com.naive.domain.Test;
import com.naive.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author YechenGu
 * @date 2021/6/30 5:24 下午
 */
@Api("测验功能")
@RestController
@CrossOrigin
@RequestMapping("api/v1/test")
public class TestController {
    @Autowired
    private TestService testService;

    @ApiOperation("存放答题情况")
    @PostMapping("add")
    public int add(Test test){
        return testService.add(test);
    }

    @ApiOperation("查找答题情况")
    @GetMapping("findStuAnswer/{stuNo}/{paperNo}")
    public Test findStuAnswer(@PathVariable("stuNo") int stuNo, @PathVariable("paperNo") int paperNo){
        return testService.findStuAnswer(stuNo,paperNo);
    }

    @ApiOperation("阅卷")
    @PostMapping("update")
    public int update(Test test){
        return testService.update(test);
    }
}
