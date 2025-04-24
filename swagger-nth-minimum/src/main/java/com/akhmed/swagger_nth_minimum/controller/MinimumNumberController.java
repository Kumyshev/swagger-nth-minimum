package com.akhmed.swagger_nth_minimum.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akhmed.swagger_nth_minimum.service.MinimumNumberService;

@RestController
@RequestMapping(value = "/api")
public class MinimumNumberController {

    @Autowired
    private MinimumNumberService minimumNumberService;

    @GetMapping("/minimum")
    public Integer findMinimumNumber(@RequestParam String filePath, @RequestParam int n) throws IOException {
        return minimumNumberService.findMinimumNumber(filePath, n);
    }

}
