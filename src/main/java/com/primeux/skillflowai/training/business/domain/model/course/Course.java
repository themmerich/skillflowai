package com.primeux.skillflowai.training.business.domain.model.course;

import com.primeux.skillflowai.files.business.domain.model.ImageId;
import com.primeux.skillflowai.training.business.domain.model.quiz.Quiz;
import lombok.Data;

import java.time.Period;
import java.util.List;

@Data
public class Course {
    private CourseId id;
    private String tenantId;
    private ImageId courseImage;
    private String title;
    private String description;
    private CourseStatus status;
    private Period repeatInterval;

    private List<EnrolledUser> enrolledUsers;
    private List<Lesson> lessons;

    private Quiz quiz;

}
