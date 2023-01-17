package com.antonov.projy3.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Task1Response {
    private char letter;
    private long letterCount;
    private long maxSequenceLength;

}
