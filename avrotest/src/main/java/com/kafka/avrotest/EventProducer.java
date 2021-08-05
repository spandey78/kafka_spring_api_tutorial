package com.kafka.avrotest;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@CommonsLog(topic = "EventProducer Logger")
public class EventProducer
{
    @Value("${topic.name}")
    private String TOPIC;

    private final KafkaTemplate<String, AvailabilityEvent> kafkaTemplate;

    @Autowired
    public EventProducer(KafkaTemplate<String, AvailabilityEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    void sendMessage(AvailabilityEvent event) {
        this.kafkaTemplate.send(this.TOPIC, event.getNotifyingBIC(), event);
        log.info(String.format("Produced event -> %s", event.getEventBIC()));
    }

}
