package com.primeux.skillflowai.training.business.domain.services;

import com.primeux.skillflowai.files.business.domain.model.ImageId;
import com.primeux.skillflowai.files.business.ports.in.usecases.CreateImageUseCase;
import com.primeux.skillflowai.files.business.ports.in.usecases.CreateImageUseCase.CreateImageCommand;
import com.primeux.skillflowai.shared.annotation.UseCase;
import com.primeux.skillflowai.training.business.domain.model.course.Course;
import com.primeux.skillflowai.training.business.domain.model.course.CourseId;
import com.primeux.skillflowai.training.business.domain.model.course.CourseStatus;
import com.primeux.skillflowai.training.business.ports.in.usecases.CreateCourseUseCase;
import com.primeux.skillflowai.training.business.ports.in.usecases.ReadCourseUseCase;
import com.primeux.skillflowai.training.business.ports.in.usecases.UpdateCourseUseCase;
import com.primeux.skillflowai.training.business.ports.out.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@UseCase
@RequiredArgsConstructor
class CourseCrudService implements CreateCourseUseCase, UpdateCourseUseCase, ReadCourseUseCase {

    private final CourseRepository courseRepository;
    private final CreateImageUseCase createImageUseCase;

    @Override
    public Optional<Course> read(CourseId courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public List<Course> readAll() {
        return courseRepository.findAll();
    }

    @Override
    @Transactional
    public void create(CreateCourseCommand command) {
        Course course = new Course();
        course.setStatus(CourseStatus.DRAFT);
        course.setId(new CourseId());
        course.setTitle(command.title());
        course.setDescription(command.description());

        courseRepository.save(course);
    }

    @Override
    @Transactional
    public void update(UpdateCourseCommand command) {
        Course courseToUpdate = loadCourseOrThrowError(CourseId.fromString(command.id()));
        courseToUpdate.setTitle(command.title());
        courseToUpdate.setDescription(command.description());
        //TODO weitere Attribute?
        courseRepository.save(courseToUpdate);
    }

    @Override
    @Transactional
    public ImageId setCourseImage(SetCourseImageCommand command) {
        Course courseToUpdate = loadCourseOrThrowError(CourseId.fromString(command.courseId()));
        ImageId imageId = createImageUseCase.create(new CreateImageCommand(command.filename(), command.imageBytes()));
        courseToUpdate.setCourseImage(imageId);
        courseRepository.save(courseToUpdate);
        return imageId;
    }

    private Course loadCourseOrThrowError(CourseId courseId) {
        return courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course does not exist: id=" + courseId.id()));

    }
}
