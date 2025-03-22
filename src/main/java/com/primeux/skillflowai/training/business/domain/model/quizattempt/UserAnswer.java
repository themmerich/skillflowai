package com.primeux.skillflowai.training.business.domain.model.quizattempt;

import com.primeux.skillflowai.training.business.domain.model.quiz.AnswerId;
import com.primeux.skillflowai.training.business.domain.model.quiz.QuestionId;
import lombok.Data;

import java.util.List;

@Data
public class UserAnswer {

    private QuestionId questionId;
    private List<AnswerId> answers;
}
