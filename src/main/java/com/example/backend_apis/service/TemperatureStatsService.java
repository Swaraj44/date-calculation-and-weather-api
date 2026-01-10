package com.example.backend_apis.service;

import org.springframework.stereotype.Service;



@Service
public class TemperatureStatsService {

    private final WeatherService weatherService;
    private final NumberToWordsService numberToWordsService;


    public TemperatureStatsService(WeatherService weatherService, NumberToWordsService numberToWordsService) {
        this.weatherService = weatherService;
        this.numberToWordsService = numberToWordsService;

    }


    public Object[] calculate(String startDate, String endDate) {

        double[] stats = weatherService.fetchTemperatures(startDate, endDate);

        //System.out.println("====--->  Temperature Stats: " + stats[0] + ", " + stats[1] + ", " + stats[2]);


        return new Object[] {
                stats[0],
                stats[1],
                stats[2],
                tempToText(stats[0]),
                tempToText(stats[1]),
                tempToText(stats[2])
        };
    }



    private String tempToText(double value) {
        String sign = value < 0 ? "minus " : "positive ";
        String number = numberToWordsService.convert(String.valueOf(Math.abs(value)));

        return sign + number;
    }
}
