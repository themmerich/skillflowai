package com.primeux.skillflowai.training.infrastructure.persistence.jpa;

import com.primeux.skillflowai.files.business.domain.model.ImageId;
import com.primeux.skillflowai.shared.mapper.SkillflowEntityMapper;
import com.primeux.skillflowai.training.business.domain.model.course.Course;
import com.primeux.skillflowai.training.business.domain.model.course.CourseId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
interface TrainingEntityMapper extends SkillflowEntityMapper {

    @Mapping(target = "id", source = "id", qualifiedByName = "courseId")
    @Mapping(target = "repeatInterval", source = "repeatInterval", qualifiedByName = "period")
    @Mapping(target = "enrolledUsers", ignore = true)
    @Mapping(target = "lessons", ignore = true)
    @Mapping(target = "quiz", ignore = true)
    @Mapping(target = "courseImage", source = "courseImage", qualifiedByName = "imageId")
    Course toCourse(CourseEntity source);

    @Mapping(target = "id", source = "id.id")
    @Mapping(target = "courseImage", source = "courseImage.id")
    CourseEntity toCourseEntity(Course course);

    @Named("courseId")
    default CourseId toCourseId(UUID id) {
        return new CourseId(id);
    }

    @Named("imageId")
    default ImageId toImageId(UUID id) {
        if (id == null) {
            return null;
        }
        return new ImageId(id);
    }

}
