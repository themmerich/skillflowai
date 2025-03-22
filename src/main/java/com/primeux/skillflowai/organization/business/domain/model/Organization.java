package com.primeux.skillflowai.organization.business.domain.model;

import com.primeux.skillflowai.files.business.domain.model.ImageId;
import lombok.Data;

@Data
public class Organization {

    private OrganizationId id;
    private String name;
    private ImageId image;
}
