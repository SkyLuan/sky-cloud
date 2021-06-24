package com.sky.cloud.demoamqp.producer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 马博士
 */
@Component
public class ReceivePushMsgListener {

    /**
     * 消息监听
     * @param message
     */
    @RabbitListener(bindings =
            @QueueBinding(exchange = @Exchange(value = "exchange", durable = "true",type = ExchangeTypes.TOPIC),
                value = @Queue(value = "test", durable = "true")
                    ,key = "rk"
        ))
    public void messageListener(Message message){
        String msg = new String(message.getBody());
        System.out.println("==messageListener1===========" + msg);

    }

    @RabbitListener(bindings =
            @QueueBinding(exchange = @Exchange(value = "exchange-g", durable = "true",type = ExchangeTypes.FANOUT),
                value = @Queue(value = "test-g", durable = "true")
                    ,key = "rk-g"
        ))
    public void messageListenerg(Message message){
        String msg = new String(message.getBody());
        System.out.println("==messageListenergggg===========" + msg);

    }

    @RabbitListener(queues = "test")
    public void messageListener2(Message message){
        String msg = new String(message.getBody());
        System.out.println("==messageListener2===========" + msg);

    }


}
