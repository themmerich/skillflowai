package com.primeux.skillflowai.training.business.domain.model.quiz;

import lombok.Data;

import java.util.List;

@Data
public class Question {
    private QuestionId id;
    private String question;
    private List<Answer> answers;
    private int points = 1;     // the points the user gets for correctly answering the question
}
