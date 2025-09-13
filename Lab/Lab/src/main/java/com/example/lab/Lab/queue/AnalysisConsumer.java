package com.example.lab.Lab.queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class AnalysisConsumer {

    @RabbitListener(queues = "queue.analiza")
    public void receiveMessage(AnalysisConsumer analysisConsumer){
        System.out.println("message received " + analysisConsumer);
    }
}
