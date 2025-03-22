package com.primeux.skillflowai.training.business.domain.model.course;

import com.primeux.skillflowai.organization.business.domain.model.User;

import java.time.LocalDateTime;

public class EnrolledUser {
    private User user;
    private LocalDateTime enrolledAt;
    private CourseProgress progress;
}
