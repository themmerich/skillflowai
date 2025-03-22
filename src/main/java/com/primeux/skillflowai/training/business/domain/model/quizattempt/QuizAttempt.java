package com.primeux.skillflowai.training.business.domain.model.quizattempt;

import com.primeux.skillflowai.organization.business.domain.model.UserId;
import com.primeux.skillflowai.training.business.domain.model.quiz.QuizId;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class QuizAttempt {
    private QuizId quizId;
    private UserId userId;

    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
    private List<UserAnswer> userAnswers;   // the concrete answers of the user to the questions of the quiz
    private int score;
    private boolean completed;
}
