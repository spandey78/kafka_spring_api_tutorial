package com.npp.service_availability;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.kafka.avrotest.AvailabilityEvent;

@Service
@CommonsLog(topic = "EventConsumer Logger")
public class ServiceAvailabilityEventConsumer
{
    @Value("${topic.name}")
    private String topicName;

    @KafkaListener(topics = "availability-event", groupId = "availability_group_channel")
    public void consume(ConsumerRecord<String, AvailabilityEvent> eventRecord) {
        log.info(String.format("Consumed message -> %s", eventRecord.value()));
    }
}