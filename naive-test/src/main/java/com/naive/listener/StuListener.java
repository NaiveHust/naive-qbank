package com.naive.listener;

import com.naive.service.TestService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author YechenGu
 * @date 2021/7/3 9:27 上午
 */
@Component
public class StuListener {
    @Autowired
    private TestService testService;

    @RabbitListener(queues = "stu_queue")
    public void msg(String msg){
        System.out.println("学生消费者消费消息："+msg);
        try {
            System.out.println(Integer.valueOf(msg));
            testService.deleteByStu(Integer.valueOf(msg));
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
