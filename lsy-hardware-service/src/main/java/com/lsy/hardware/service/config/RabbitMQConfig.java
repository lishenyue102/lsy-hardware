package com.lsy.hardware.service.config;


import com.lsy.hardware.service.constants.RabbitMQConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lishenyue Created on 2021/4/4 23:37
 * @version 1.0
 */
@Configuration
public class RabbitMQConfig implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    private static Logger log = LoggerFactory.getLogger(RabbitMQConfig.class);

    @Override
    public void confirm(final CorrelationData correlationData, final boolean ack, final String cause) {
        if (ack) {
            log.info("消息id:" + correlationData.getId() + "------消息发送确认成功");
        } else {
            log.info("消息id:" + correlationData.getId() + "------消息发送确认失败:" + cause);
        }
    }

    @Override
    public void returnedMessage(final Message message, final int replyCode, final String replyText,
                                final String exchange, final String routingKey) {
        log.error("消息主体 message : {}, 消息主体 replyCode :{}, 描述：{}, 消息使用的交换器 exchange :{}, 消息使用的路由键 routing : {} "
                , message, replyCode, replyText, exchange, routingKey);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory factory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setConfirmCallback(this);

        /**
         * 当mandatory标志位设置为true时
         * 如果exchange根据自身类型和消息routingKey无法找到一个合适的queue存储消息
         * 那么broker会调用basic.return方法将消息返还给生产者
         * 当mandatory设置为false时，出现上述情况broker会直接将消息丢弃
         */
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(this);
        //使用单独的发送连接，避免生产者由于各种原因阻塞而导致消费者同样阻塞
        rabbitTemplate.setUsePublisherConnection(true);

        return rabbitTemplate;
    }

    @Bean
    public DirectExchange dlxExchange() {
        return new DirectExchange(RabbitMQConstant.DLX_EXCHANGE_NAME, true, false);
    }

    @Bean
    public Queue dlxQueue(){
        return new Queue(RabbitMQConstant.DLX_QUEUE_NAME,true,false,false);
    }

    @Bean
    public Binding dlxBinding(){
        return BindingBuilder.bind(dlxQueue()).to(dlxExchange()).with(RabbitMQConstant.DLX_ROUTING_KEY);
    }



}
