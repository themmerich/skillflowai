package com.primeux.skillflowai.organization.presentation.controller;

import com.primeux.skillflowai.files.business.domain.model.ImageId;
import com.primeux.skillflowai.organization.business.domain.model.OrganizationId;
import com.primeux.skillflowai.organization.business.ports.in.usecases.ReadOrganizationUseCase;
import com.primeux.skillflowai.organization.business.ports.in.usecases.UpdateOrganizationUseCase;
import com.primeux.skillflowai.organization.business.ports.in.usecases.UpdateOrganizationUseCase.SetOrganizationImageCommand;
import com.primeux.skillflowai.organization.business.ports.in.usecases.UpdateOrganizationUseCase.UpdateOrganizationCommand;
import com.primeux.skillflowai.organization.presentation.mapper.OrganizationResourcesMapper;
import com.primeux.skillflowai.organization.presentation.resources.OrganizationReadDto;
import com.primeux.skillflowai.shared.annotation.SkillflowRestController;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.primeux.skillflowai.organization.presentation.controller.OrganizationAuthorities.READ_ORGANIZATION;
import static com.primeux.skillflowai.organization.presentation.controller.OrganizationAuthorities.UPDATE_ORGANIZATION;

@SkillflowRestController("/api/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final ReadOrganizationUseCase readOrganizationUseCase;
    private final UpdateOrganizationUseCase updateOrganizationUseCase;
    private final OrganizationResourcesMapper organizationResourcesMapper;

    @GetMapping
    @ResponseBody
    @PreAuthorize(READ_ORGANIZATION)
    public List<OrganizationReadDto> readAll() {
        return readOrganizationUseCase.readAll().stream().map(organizationResourcesMapper::toReadDto).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    @ResponseBody
    @PreAuthorize(READ_ORGANIZATION)
    public OrganizationReadDto read(@PathVariable String id) {
        return readOrganizationUseCase.read(OrganizationId.fromString(id)).map(organizationResourcesMapper::toReadDto).orElseThrow(() -> new RuntimeException("Organization not found for id " + id));
    }

    @PutMapping
    @ResponseBody
    @PreAuthorize(UPDATE_ORGANIZATION)
    public void update(@RequestBody UpdateOrganizationCommand command) {
        updateOrganizationUseCase.update(command);
    }

    @PutMapping(value = "/{id}/image", consumes = "multipart/form-data")
    @PreAuthorize(UPDATE_ORGANIZATION)
    public ImageId uploadImageForOrganization(@PathVariable("id") String id, @RequestParam("image") MultipartFile image) {
        return updateOrganizationUseCase.setOrganizationImage(createSetOrganizationImageCommand(id, image));
    }

    private SetOrganizationImageCommand createSetOrganizationImageCommand(String organizationId, MultipartFile image) {
        try {
            return new SetOrganizationImageCommand(organizationId, image.getOriginalFilename(), image.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Could not add image to organization " + organizationId, e);
        }
    }
}
