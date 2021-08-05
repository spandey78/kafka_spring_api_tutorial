package com.kafka.avrotest;

public class AvailabilityEventResponse
{
    private String notifyingBIC;

    public AvailabilityEventResponse(String notifyingBIC)
    {
        this.notifyingBIC = notifyingBIC;
    }

    public String getNotifyingBIC() {
        return notifyingBIC;
    }
}
