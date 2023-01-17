package com.antonov.projy3.service;

import com.antonov.projy3.dto.Task1Response;
import com.antonov.projy3.dto.Task2Response;

import java.util.List;

public interface WordService {
    List<Task1Response> task1(String word);

    List<Task2Response> task2();
}
