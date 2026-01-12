package com.example.chrono_climate_api.controller;

import com.example.chrono_climate_api.dto.TemperatureStatsRequest;
import com.example.chrono_climate_api.dto.TemperatureStatsResponse;
import com.example.chrono_climate_api.service.TemperatureStatsService;
import com.example.chrono_climate_api.util.InputValidator;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class TemperatureStatsController {

    private final TemperatureStatsService service;
  

    public TemperatureStatsController(TemperatureStatsService service) {
        this.service = service;
    }


    @PostMapping("/temperature-stats-for-dhaka")
    public TemperatureStatsResponse getStats(@RequestBody TemperatureStatsRequest request) {
        InputValidator.validateDate(request.getStartDate());
        InputValidator.validateDate(request.getEndDate());

        Object[] result = service.calculate(request.getStartDate(),request.getEndDate());

        

        return new TemperatureStatsResponse(
                (double) result[0],(double) result[1],(double) result[2],
                (String) result[3],(String) result[4],(String) result[5] );
                
    }

  

}
