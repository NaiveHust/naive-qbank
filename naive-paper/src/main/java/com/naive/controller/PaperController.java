package com.naive.controller;

import com.naive.config.RabbitMQConfig;
import com.naive.domain.Paper;
import com.naive.domain.Problem;
import com.naive.service.PaperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YechenGu
 * @date 2021/6/28 4:30 下午
 */
@Api(tags = "试卷管理")
@RestController
@CrossOrigin
@RequestMapping("api/v1/paper")
public class PaperController {
    @Autowired
    private PaperService paperService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     *
     * @param paperId
     * @return
     */
    @ApiOperation(value = "显示试卷",notes = "学生选择某张试卷,向后台传该试卷的id,根据前端传来的试卷id查询试卷信息表,得到json格式,并将该列表返回给前端,前端渲染")
    @GetMapping("find_paper/{paperId}")
    public Paper findPaper(@PathVariable("paperId") int paperId){
        return paperService.findById(paperId);
    }

    /**
     *
     * @param paper
     * @return
     */
    @ApiOperation(value = "老师创建试卷")
    @PostMapping("add")
    public int addPaper(@RequestBody Paper paper){
        return paperService.add(paper);
    }

    /**
     *
     * @param paper
     * @return
     */
    @ApiOperation(value = "老师更新试卷信息")
    @PostMapping("update_by_id")
    public int updateById(@RequestBody Paper paper){
        return paperService.updateById(paper);
    }

    /**
     *
     * @param paperId
     * @return
     */
    @ApiOperation(value = "老师删除试卷")
    @GetMapping("delete_by_id/{paperId}")
    public int deleteById(@PathVariable("paperId") int paperId){
        rabbitTemplate.convertAndSend(RabbitMQConfig.ITEM_TOPIC_EXCHANGE,"paper.deleteId",String.valueOf(paperId));
        System.out.println("试卷生产者生产消息:"+String.valueOf(paperId));
        return paperService.deleteById(paperId);
    }

    /**
     *
     * @param paperClass
     * @param index
     * @param size
     * @return
     */
    @ApiOperation("根据课程分页寻找试卷")
    @GetMapping("findByCla/{paperClass}/{index}/{size}")
    public List<Paper> findByCla(@PathVariable("paperClass") String paperClass,
                                   @PathVariable("index") int index,
                                   @PathVariable("size") int size){
        return paperService.findByCla(paperClass,index,size);
    }

    /**
     *
     * @param paperTea
     * @param index
     * @param size
     * @return
     */
    @ApiOperation("根据教师分页寻找试卷")
    @GetMapping("findByTea/{paperTea}/{index}/{size}")
    public List<Paper> findByTea(@PathVariable("paperTea") int paperTea,
                                   @PathVariable("index") int index,
                                   @PathVariable("size") int size){
        return paperService.findByTea(paperTea,index,size);
    }

    @GetMapping("deleteByTea/{tid}")
    public int deleteByTea(@PathVariable("tid") int tid){
        return paperService.deleteByTea(tid);
    }

}
