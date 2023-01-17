package com.antonov.projy3.repository;

import com.antonov.projy3.model.Letter;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class LetterRepository {
    private final List<Letter> list = Collections.synchronizedList(new ArrayList<>());

    public Letter add(Letter letter) {
        Optional<Letter> optResult = list.stream()
                .filter(l -> l.getLtr().equals(letter.getLtr()))
                .findFirst();
        optResult.ifPresentOrElse(
                l -> {
                    l.setWordCount(l.getWordCount() + letter.getWordCount());
                    l.setLetterCount(l.getLetterCount() + letter.getLetterCount());
                    l.setMaxSequenceSum(l.getMaxSequenceSum() + letter.getMaxSequenceSum());
                },
                () -> list.add(letter)
        );
        return optResult.orElse(letter);
    }

    public List<Letter> getAll() {
        return list.stream()
                .sorted(Comparator.comparingInt(Letter::getLtr))
                .toList();
    }
}
