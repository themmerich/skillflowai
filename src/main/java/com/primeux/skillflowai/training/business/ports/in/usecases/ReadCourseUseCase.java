package com.primeux.skillflowai.training.business.ports.in.usecases;

import com.primeux.skillflowai.shared.usecase.ReadEntityUseCase;
import com.primeux.skillflowai.training.business.domain.model.course.Course;
import com.primeux.skillflowai.training.business.domain.model.course.CourseId;

public interface ReadCourseUseCase extends ReadEntityUseCase<Course, CourseId> {
}
