package com.kafka.avrotest;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@CommonsLog(topic = "EventConsumer Logger")
public class EventConsumer
{
   @Value("${topic.name}")
   private String topicName;

   @KafkaListener(topics = "availability-event", groupId = "availability_group_pads")
   public void consume(ConsumerRecord<String, AvailabilityEvent> eventRecord) {
       log.info(String.format("Consumed message -> %s", eventRecord.value()));
   }
}
