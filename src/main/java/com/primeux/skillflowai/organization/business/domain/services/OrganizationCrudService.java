package com.primeux.skillflowai.organization.business.domain.services;

import com.primeux.skillflowai.files.business.domain.model.ImageId;
import com.primeux.skillflowai.files.business.ports.in.usecases.CreateImageUseCase;
import com.primeux.skillflowai.files.business.ports.in.usecases.CreateImageUseCase.CreateImageCommand;
import com.primeux.skillflowai.organization.business.domain.model.Organization;
import com.primeux.skillflowai.organization.business.domain.model.OrganizationId;
import com.primeux.skillflowai.organization.business.ports.in.usecases.ReadOrganizationUseCase;
import com.primeux.skillflowai.organization.business.ports.in.usecases.UpdateOrganizationUseCase;
import com.primeux.skillflowai.organization.business.ports.out.repositories.OrganizationRepository;
import com.primeux.skillflowai.shared.annotation.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@UseCase
@RequiredArgsConstructor
class OrganizationCrudService implements ReadOrganizationUseCase, UpdateOrganizationUseCase {
    private final OrganizationRepository organizationRepository;
    private final CreateImageUseCase createImageUseCase;

    @Override
    public Optional<Organization> read(OrganizationId id) {
        return organizationRepository.findById(id);
    }

    @Override
    public List<Organization> readAll() {
        return organizationRepository.findAll();
    }

    @Override
    @Transactional
    public void update(UpdateOrganizationCommand command) {
        Organization organizationToUpdate = loadOrganizationOrThrowError(OrganizationId.fromString(command.id()));
        organizationToUpdate.setName(command.name());
        organizationRepository.save(organizationToUpdate);
    }

    @Override
    @Transactional
    public ImageId setOrganizationImage(SetOrganizationImageCommand command) {
        Organization organizationToUpdate = loadOrganizationOrThrowError(OrganizationId.fromString(command.organizationId()));
        ImageId imageId = createImageUseCase.create(new CreateImageCommand(command.filename(), command.imageBytes()));
        organizationToUpdate.setImage(imageId);
        organizationRepository.save(organizationToUpdate);
        return imageId;
    }

    private Organization loadOrganizationOrThrowError(OrganizationId organizationId) {
        return organizationRepository.findById(organizationId).orElseThrow(() -> new RuntimeException("Organization does not exist: id=" + organizationId.id()));
    }
}
