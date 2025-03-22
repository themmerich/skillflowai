package com.primeux.skillflowai.training.business.ports.in.usecases;

import com.primeux.skillflowai.files.business.domain.model.ImageId;
import jakarta.validation.constraints.NotBlank;

public interface UpdateCourseUseCase {

    void update(UpdateCourseCommand command);

    ImageId setCourseImage(SetCourseImageCommand command);

    record UpdateCourseCommand(
            @NotBlank String id,
            String title,
            String description
    ) {
    }

    record SetCourseImageCommand(@NotBlank String courseId, String filename, byte[] imageBytes) {
    }
}
