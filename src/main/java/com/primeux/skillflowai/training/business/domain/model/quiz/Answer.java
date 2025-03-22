package com.primeux.skillflowai.training.business.domain.model.quiz;

import lombok.Data;

@Data
public class Answer {

    private String answer;
    private boolean correct;
    private String explanation;  // optional; can show the user an explanation why this answer is correct or wrong
}
