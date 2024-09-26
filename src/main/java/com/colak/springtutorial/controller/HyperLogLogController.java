package com.colak.springtutorial.controller;

import com.colak.springtutorial.service.HyperLogLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HyperLogLogController {

    private final HyperLogLogService hyperLogLogService;

    //http://localhost:8080/add?element=element1
    //http://localhost:8080/add?element=element2
    //http://localhost:8080/add?element=element3
    @GetMapping("/add")
    public String addElement(@RequestParam String element) {
        hyperLogLogService.addToHyperLogLog(element);
        return "Element added!";
    }

    // http://localhost:8080/count
    @GetMapping("/count")
    public String getCount() {
        long count = hyperLogLogService.getHyperLogLogCount();
        return "Approximate count of unique elements: " + count;
    }
}

