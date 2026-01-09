package com.example.backend_apis.service;

import org.springframework.stereotype.Service;

@Service
public class DateCalculationService {

    // Entry method
    public long calculateDaysBetween(String startDate, String endDate) {
        long start = toDays(startDate);
        long end = toDays(endDate);
        return Math.abs(end - start);
    }

    //(YYYY-MM-DD) → total days since 0000-03-01
    private long toDays(String date) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        // Shifting Jan & Feb to previous year
        if (month < 3) {
            year--;
            month += 12;
        }

        // For Gregorian calendar formula
        return 365L * year
                + year / 4
                - year / 100
                + year / 400
                + (153 * (month - 3) + 2) / 5
                + day - 1;
    }
}
