package com.primeux.skillflowai.training.business.ports.in.usecases;

public interface CreateCourseUseCase {

    void create(CreateCourseCommand command);

    record CreateCourseCommand(
            String title,
            String description
    ) {
    }

    ;
}
