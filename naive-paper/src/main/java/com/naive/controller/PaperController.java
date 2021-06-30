package com.naive.controller;

import com.naive.domain.Paper;
import com.naive.service.PaperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author YechenGu
 * @date 2021/6/28 4:30 下午
 */
@Api("试卷管理")
@RestController
@RequestMapping("api/v1/paper")
public class PaperController {
    @Autowired
    private PaperService paperService;

    @ApiOperation(value = "显示试卷",notes = "学生选择某张试卷,向后台传该试卷的id,根据前端传来的试卷id查询试卷信息表,得到json格式,并将该列表返回给前端,前端渲染")
    @GetMapping("find_basicInfo/{paperId}")
    public Paper findBasicInfo(@PathVariable("paperId") int paperId){
        return paperService.findById(paperId);
    }

    @ApiOperation(value = "老师创建试卷")
    @PostMapping("add")
    public int addPaper(@RequestBody Paper paper){
        return paperService.add(paper);
    }

    @ApiOperation(value = "老师更新试卷信息")
    @PostMapping("update_by_id")
    public int updateById(@RequestBody Paper paper){
        return paperService.updateById(paper);
    }

    @ApiOperation(value = "老师删除试卷")
    public int deleteById(@PathVariable("paperId") int paperId){
        return paperService.deleteById(paperId);
    }
}
