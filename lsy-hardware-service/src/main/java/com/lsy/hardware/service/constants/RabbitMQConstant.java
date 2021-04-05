package com.lsy.hardware.service.constants;

/**
 * @author lishenyue Created on 2021/4/4 23:48
 * @version 1.0
 */
public abstract class RabbitMQConstant {

    /**
     * 死信队列交换机名
     */
    public static final String DLX_EXCHANGE_NAME = "dlx.lsy.hardware.exchange";

    /**
     * 死信队列队列名
     */
    public static final String DLX_QUEUE_NAME = "dlx.lsy.hardware.queue";

    /**
     * 死信队列路由
     */
    public static final String DLX_ROUTING_KEY = "dlx.lsy";


}
