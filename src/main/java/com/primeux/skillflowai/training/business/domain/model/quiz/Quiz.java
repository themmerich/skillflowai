package com.primeux.skillflowai.training.business.domain.model.quiz;

import lombok.Data;

import java.util.List;

@Data
public class Quiz {

    private QuizId id;
    private TimeLimit timeLimit;    //optional; if provided, each quiz attempt has to be finished in the given time
    private int neededPointsToPass;  // the number of points the user must reach to pass the quiz
    private List<Question> questions;
}
