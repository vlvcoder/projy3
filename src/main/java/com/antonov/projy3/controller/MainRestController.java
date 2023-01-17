package com.antonov.projy3.controller;

import com.antonov.projy3.dto.Task1Response;
import com.antonov.projy3.dto.Task2Response;
import com.antonov.projy3.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MainRestController {
    private final WordService wordService;

    @GetMapping("/analyze/{input_string}")
    public List<Task1Response> analyze(@PathVariable("input_string") String word) {
        return wordService.task1(word.toLowerCase());
    }

    @GetMapping("/statistics")
    public List<Task2Response> statistics() {
        return wordService.task2();
    }

}
