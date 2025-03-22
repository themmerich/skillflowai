package com.primeux.skillflowai.files.business.ports.in.usecases;

import com.primeux.skillflowai.files.business.domain.model.ImageId;

public interface CreateImageUseCase {

    ImageId create(CreateImageCommand command);

    record CreateImageCommand(String filename, byte[] imageBytes) {
    }
}
