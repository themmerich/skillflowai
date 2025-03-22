package com.primeux.skillflowai.training.business.domain.model.course;

import lombok.Data;

import java.util.List;

@Data
public class Lesson {
    private LessonId id;
    private int order;
    private String title;
    private String description;
    private List<Section> content;
}
