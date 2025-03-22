package com.primeux.skillflowai.training.presentation.mapper;

import com.primeux.skillflowai.training.business.domain.model.course.Course;
import com.primeux.skillflowai.training.presentation.resources.CourseDetailDto;
import com.primeux.skillflowai.training.presentation.resources.CourseOverviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrainingResourcesMapper {

    @Mapping(target = "id", source = "source.id.id")
    @Mapping(target = "courseImageId", source = "source.courseImage.id")
    CourseOverviewDto toCourseOverviewDto(Course source);

    @Mapping(target = "id", source = "source.id.id")
    @Mapping(target = "courseImageId", source = "source.courseImage.id")
    CourseDetailDto toCourseDetailDto(Course source);
}
