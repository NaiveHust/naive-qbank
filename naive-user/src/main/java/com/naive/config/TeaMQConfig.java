package com.naive.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author YechenGu
 * @date 2021/7/8 11:09 上午
 */
@Component
public class TeaMQConfig {
    //交换机名称
    public static final String ITEM_TOPIC_EXCHANGE = "tea_exchange";

    //队列名称
    public static final String ITEM_QUEUE = "tea_queue";

    /**
     * 声明交换机
     */
    @Bean("teaTopicExchange")
    public Exchange topicExchange(){
        return ExchangeBuilder.topicExchange(ITEM_TOPIC_EXCHANGE).durable(true).build();
    }

    /***
     * 声明队列
     */
    @Bean("teaQueue")
    public Queue itemQueue(){
        return QueueBuilder.durable(ITEM_QUEUE).build();
    }


    /**
     * 绑定队列和交换机
     * @param queue
     * @param exchange
     * @return
     */
    @Bean("teaBind")
    public Binding itemQueueExchange(@Qualifier("teaQueue") Queue queue,
                                     @Qualifier("teaTopicExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("tea.#").noargs();
    }
}
