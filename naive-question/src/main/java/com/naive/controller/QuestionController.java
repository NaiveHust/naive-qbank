package com.naive.controller;

import com.naive.domain.Problem;
import com.naive.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YechenGu
 * @date 2021/6/28 3:47 下午
 */
@Api(tags = "试题管理")
@RestController
@CrossOrigin
@RequestMapping("api/v1/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @ApiOperation("根据id寻找试题")
    @GetMapping("find_by_id/{proId}")
    public Object findById(@PathVariable("proId") int proId){
        return questionService.findById(proId);
    }

    /**
     * add problem via id
     * */
    @ApiOperation("老师添加试题")
    @PostMapping("add")
    public int add(@RequestBody Problem problem){
        System.out.println(problem.toString());
        return questionService.add(problem);
    }

    /**
     * update problem via id
     * */
    @ApiOperation("根据id更新试题")
    @PostMapping("update_by_id")
    public int updateById(@RequestBody Problem problem){
        System.out.println(problem.toString());
        return questionService.updateById(problem);
    }

    /**
     * delete problem via id
     * */
    @ApiOperation("根据id删除试题")
    @GetMapping("delete_by_id/{proId}")
    public int deleteById(@PathVariable("proId") int proId){
        return questionService.deleteById(proId);
    }

    /**
     *
     * @param simple
     * @param index
     * @param size
     * @return
     */
    @ApiOperation("根据题目简称分页寻找试题")
    @GetMapping("findBySimple/{simple}/{index}/{size}")
    public List<Problem> findBySimple(@PathVariable("simple") String simple,
                                   @PathVariable("index") int index,
                                   @PathVariable("size") int size){
        return questionService.findBySimple(simple,index,size);
    }

    /**
     *
     * @param difficulty
     * @param index
     * @param size
     * @return
     */
    @ApiOperation("根据难度分页寻找试题")
    @GetMapping("findByDif/{difficulty}/{index}/{size}")
    public List<Problem> findByDif(@PathVariable("difficulty") String difficulty,
                                   @PathVariable("index") int index,
                                   @PathVariable("size") int size){
        return questionService.findByDif(difficulty,index,size);
    }

    /**
     *
     * @param proClass
     * @param index
     * @param size
     * @return
     */
    @ApiOperation("根据课程分页寻找试题")
    @GetMapping("findByCla/{proClass}/{index}/{size}")
    public List<Problem> findByCla(@PathVariable("proClass") String proClass,
                                   @PathVariable("index") int index,
                                   @PathVariable("size") int size){
        return questionService.findByCla(proClass,index,size);
    }

    /**
     *
     * @param proTea
     * @param index
     * @param size
     * @return
     */
    @ApiOperation("根据教师分页寻找试题")
    @GetMapping("findByTea/{proTea}/{index}/{size}")
    public List<Problem> findByTea(@PathVariable("proTea") int proTea,
                                   @PathVariable("index") int index,
                                   @PathVariable("size") int size){
        return questionService.findByTea(proTea,index,size);
    }
}
