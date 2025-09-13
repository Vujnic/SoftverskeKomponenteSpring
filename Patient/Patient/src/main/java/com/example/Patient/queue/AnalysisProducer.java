package com.example.Patient.queue;

import com.example.Patient.dto.AnalysisCreateDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AnalysisProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${queue.analiza}")
    private String queue;

    public void sendMessage(AnalysisCreateDto analysisCreateDto){
        rabbitTemplate.convertAndSend(queue, "lab", analysisCreateDto);

        System.out.println("message sent");
    }

}
