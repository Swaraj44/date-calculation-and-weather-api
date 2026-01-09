package com.example.backend_apis.dto;

public class DateDiffResponse {

    private long numberOfDays;

    public DateDiffResponse(long numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public long getNumberOfDays() {
        return numberOfDays;
    }
}
