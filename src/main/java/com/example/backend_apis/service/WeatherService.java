package com.example.backend_apis.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class WeatherService {


    private static final String BASE_URL = "https://api.open-meteo.com/v1/forecast" + "?latitude=23.8103&longitude=90.4125" +
            "&daily=temperature_2m_max,temperature_2m_min" + "&timezone=Asia/Dhaka" +"&start_date=%s&end_date=%s";


    private final RestTemplate restTemplate = new RestTemplate();

    @SuppressWarnings("unchecked")
    public double[] fetchTemperatures(String startDate, String endDate) {



        String url = String.format(BASE_URL, startDate, endDate);

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        Map<String, Object> daily = (Map<String, Object>) response.get("daily");




        //System.out.println("====--->  Weather API Response: " + response);


        
        List<Double> maxTemps = (List<Double>) daily.get("temperature_2m_max");
        List<Double> minTemps = (List<Double>) daily.get("temperature_2m_min");


        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double sum = 0;
        int count = 0;


        for (int i = 0; i < maxTemps.size(); i++) {
            min = Math.min(min, minTemps.get(i));
            max = Math.max(max, maxTemps.get(i));
            sum += minTemps.get(i) + maxTemps.get(i);
            count += 2;
        }


        double avg = sum / count;


        return new double[] { round(min), round(max), round(avg) };
    }


    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
