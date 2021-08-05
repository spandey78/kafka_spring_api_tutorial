package com.kafka.avrotest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/event")
public class AvroTestController
{
    private final EventProducer producer;

    @Autowired
    AvroTestController(EventProducer producer) {
        this.producer = producer;
    }

    @RequestMapping(value = "/publish", method = {RequestMethod.GET, RequestMethod.POST})
    public AvailabilityEventResponse sendMessageToKafkaTopic(@RequestParam("nBIC") String nBIC, @RequestParam("eBIC") String eBIC,
                                        @RequestParam("status") String status) {
       System.out.println("nBIC - > " + nBIC);
       System.out.println("eBIC - > " + eBIC);
       System.out.println("status - > " + status);

       AvailabilityEvent event = new AvailabilityEvent(nBIC, eBIC, status);
       producer.sendMessage(event);
       return new AvailabilityEventResponse(nBIC);
    }
}
