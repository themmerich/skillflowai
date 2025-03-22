package com.primeux.skillflowai.training.infrastructure.persistence.jpa;

import com.primeux.skillflowai.training.business.domain.model.course.Course;
import com.primeux.skillflowai.training.business.domain.model.course.CourseId;
import com.primeux.skillflowai.training.business.ports.out.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
class CourseJpaRepository implements CourseRepository {
    private final SpringDataCourseJpaRepository springDataCourseJpaRepository;
    private final TrainingEntityMapper mapper;

    @Override
    public List<Course> findAll() {
        return springDataCourseJpaRepository.findAll().stream().map(mapper::toCourse).toList();
    }

    @Override
    public Optional<Course> findById(CourseId courseId) {
        return springDataCourseJpaRepository.findById(courseId.id()).map(mapper::toCourse);
    }

    @Override
    public Course save(Course course) {
        CourseEntity saved = springDataCourseJpaRepository.save(mapper.toCourseEntity(course));
        return mapper.toCourse(saved);
    }
}
