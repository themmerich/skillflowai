package com.primeux.skillflowai.training.presentation.controller;

import com.primeux.skillflowai.files.business.domain.model.ImageId;
import com.primeux.skillflowai.shared.annotation.SkillflowRestController;
import com.primeux.skillflowai.training.business.domain.model.course.CourseId;
import com.primeux.skillflowai.training.business.ports.in.usecases.CreateCourseUseCase;
import com.primeux.skillflowai.training.business.ports.in.usecases.CreateCourseUseCase.CreateCourseCommand;
import com.primeux.skillflowai.training.business.ports.in.usecases.ReadCourseUseCase;
import com.primeux.skillflowai.training.business.ports.in.usecases.UpdateCourseUseCase;
import com.primeux.skillflowai.training.business.ports.in.usecases.UpdateCourseUseCase.SetCourseImageCommand;
import com.primeux.skillflowai.training.business.ports.in.usecases.UpdateCourseUseCase.UpdateCourseCommand;
import com.primeux.skillflowai.training.presentation.mapper.TrainingResourcesMapper;
import com.primeux.skillflowai.training.presentation.resources.CourseDetailDto;
import com.primeux.skillflowai.training.presentation.resources.CourseOverviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.primeux.skillflowai.training.presentation.controller.TrainingAuthorities.*;

@SkillflowRestController("/api/training/course")
@RequiredArgsConstructor
public class CourseController {

    private final ReadCourseUseCase readCourseUseCase;
    private final UpdateCourseUseCase updateCourseUseCase;
    private final CreateCourseUseCase createCourseUseCase;

    private final TrainingResourcesMapper courseMapper;

    @GetMapping
    @ResponseBody
    @PreAuthorize(READ_COURSE)
    public List<CourseOverviewDto> readAll() {
        return readCourseUseCase.readAll().stream().map(courseMapper::toCourseOverviewDto).toList();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @PreAuthorize(READ_COURSE)
    public CourseDetailDto read(@PathVariable String id) {
        return readCourseUseCase.read(CourseId.fromString(id)).map(courseMapper::toCourseDetailDto).orElseThrow(() -> new RuntimeException("Course not found for id " + id));
    }

    @PostMapping
    @ResponseBody
    @PreAuthorize(CREATE_COURSE)
    public void create(@RequestBody CreateCourseCommand command) {
        createCourseUseCase.create(command);
    }

    @PutMapping
    @ResponseBody
    @PreAuthorize(UPDATE_COURSE)
    public void update(@RequestBody UpdateCourseCommand command) {
        updateCourseUseCase.update(command);
    }


    @PutMapping(value = "/{courseId}/image", consumes = "multipart/form-data")
    @PreAuthorize(UPDATE_COURSE)
    public ImageId uploadImageForCourse(@PathVariable("courseId") String courseId, @RequestParam("image") MultipartFile image) {
        return updateCourseUseCase.setCourseImage(createSetCourseImageCommand(courseId, image));
    }

    private SetCourseImageCommand createSetCourseImageCommand(String courseId, MultipartFile image) {
        try {
            return new SetCourseImageCommand(courseId, image.getOriginalFilename(), image.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Could not add image to course " + courseId, e);
        }
    }
}
