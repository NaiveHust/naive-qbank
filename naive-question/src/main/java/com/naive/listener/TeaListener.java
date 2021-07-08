package com.naive.listener;

import com.naive.service.QuestionService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author YechenGu
 * @date 2021/7/8 11:14 上午
 */
@Component
public class TeaListener {
    @Autowired
    private QuestionService questionService;

    @RabbitListener(queues = "tea_queue")
    public void msg(String msg){
        System.out.println("教师消费者消费消息："+msg);
        try {
            System.out.println(Integer.valueOf(msg));
            questionService.deleteByTea(Integer.valueOf(msg));
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
