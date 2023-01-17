package com.antonov.projy3.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Task2Response {
    private char letter;
    private long requestCount;
    private double averageCountInRequest;
    private double averageSequenceLength;
}
