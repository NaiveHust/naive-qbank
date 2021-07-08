package com.naive.config;

/**
 * @author YechenGu
 * @date 2021/7/3 9:19 上午
 */

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置类
 */
@Configuration
public class PaperMQConfig {
    //交换机名称
    public static final String ITEM_TOPIC_EXCHANGE = "paper_exchange";

    //队列名称
    public static final String ITEM_QUEUE = "paper_queue";

    /**
     * 声明交换机
     */
    @Bean("paperTopicExchange")
    public Exchange topicExchange(){
        return ExchangeBuilder.topicExchange(ITEM_TOPIC_EXCHANGE).durable(true).build();
    }

    /***
     * 声明队列
     */
    @Bean("paperQueue")
    public Queue itemQueue(){
        return QueueBuilder.durable(ITEM_QUEUE).build();
    }


    /**
     * 绑定队列和交换机
     * @param queue
     * @param exchange
     * @return
     */
    @Bean("paperBind")
    public Binding itemQueueExchange(@Qualifier("paperQueue") Queue queue,
                                     @Qualifier("paperTopicExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("paper.#").noargs();
    }

}
