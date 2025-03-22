package com.primeux.skillflowai.training.presentation.resources;

import lombok.Data;

@Data
public class CourseDetailDto {
    private String id;
    private String title;
    private String description;
    private String courseImageId;

    //TODO: Welche Attribute benötigen wir?
}
