package com.antonov.projy3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Letter {
    private Character ltr;

    private long wordCount;
    private long letterCount;
    private long maxSequenceSum;

}
