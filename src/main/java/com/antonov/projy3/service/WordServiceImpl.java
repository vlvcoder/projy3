package com.antonov.projy3.service;

import com.antonov.projy3.dto.Task1Response;
import com.antonov.projy3.dto.Task2Response;
import com.antonov.projy3.model.Letter;
import com.antonov.projy3.repository.LetterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WordServiceImpl implements WordService {

    private final LetterRepository letterRepository;

    @Override
    public List<Task1Response> task1(String word) {
        return word.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .sorted()
                .map(c -> Letter.builder()
                        .ltr(c)
                        .wordCount(1)
                        .letterCount(letterCount(word, c))
                        .maxSequenceSum(maxSequenceLength(word, c))
                        .build())
                .peek(letterRepository::add)
                .map(this::response1)
                .toList();
    }

    @Override
    public List<Task2Response> task2() {
        return letterRepository
                .getAll().stream()
                .map(this::response2)
                .toList();
    }

    private long letterCount(String word, char letter) {
        return word.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c.equals(letter))
                .count();
    }

    private long maxSequenceLength(String word, char letter) {
        long result = 0;
        long current = 0;
        for (char c : word.toCharArray()) {
            if (c == letter) {
                current++;
            } else {
                if (current > 0) {
                    if (current > result) {
                        result = current;
                    }
                    current = 0;
                }
            }
        }
        if (current > result) {
            result = current;
        }
        return result;
    }

    private Task1Response response1(Letter letter) {
        return Task1Response.builder()
                .letter(letter.getLtr())
                .letterCount(letter.getLetterCount())
                .maxSequenceLength(letter.getMaxSequenceSum())
                .build();
    }

    private Task2Response response2(Letter letter) {
        return Task2Response.builder()
                .letter(letter.getLtr())
                .requestCount(letter.getWordCount())
                .averageCountInRequest((double) letter.getLetterCount() / (double) letter.getWordCount())
                .averageSequenceLength((double) letter.getMaxSequenceSum() / (double) letter.getWordCount())
                .build();
    }
}
