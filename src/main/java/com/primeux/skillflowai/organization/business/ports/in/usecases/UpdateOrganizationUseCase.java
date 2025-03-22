package com.primeux.skillflowai.organization.business.ports.in.usecases;

import com.primeux.skillflowai.files.business.domain.model.ImageId;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public interface UpdateOrganizationUseCase {

    void update(UpdateOrganizationCommand command);

    ImageId setOrganizationImage(SetOrganizationImageCommand command);

    record UpdateOrganizationCommand(
            @NotBlank String id,
            @NotBlank @Size(min = 3, max = 255) String name
    ) {
    }

    record SetOrganizationImageCommand(@NotBlank String organizationId, String filename, byte[] imageBytes) {
    }
}
