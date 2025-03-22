package com.primeux.skillflowai.training.business.ports.out.repositories;

import com.primeux.skillflowai.shared.repository.ReadEntityRepository;
import com.primeux.skillflowai.shared.repository.SaveEntityRepository;
import com.primeux.skillflowai.training.business.domain.model.course.Course;
import com.primeux.skillflowai.training.business.domain.model.course.CourseId;

public interface CourseRepository extends ReadEntityRepository<Course, CourseId>, SaveEntityRepository<Course> {

}
