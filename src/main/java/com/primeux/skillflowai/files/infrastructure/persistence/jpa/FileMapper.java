package com.primeux.skillflowai.files.infrastructure.persistence.jpa;

import com.primeux.skillflowai.files.business.domain.model.Image;
import com.primeux.skillflowai.files.business.domain.model.ImageId;
import com.primeux.skillflowai.shared.mapper.SkillflowEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
interface FileMapper extends SkillflowEntityMapper {

    @Mapping(target = "id", source = "id", qualifiedByName = "imageId")
    @Mapping(target = "imageBytes", source = "data")
    Image toImage(ImageEntity source);

    @Mapping(target = "id", source = "id.id")
    @Mapping(target = "data", source = "imageBytes")
    @Mapping(target = "tenantId", ignore = true)
    ImageEntity toImageEntity(Image image);

    @Named("imageId")
    default ImageId toImageId(UUID id) {
        if (id == null) {
            return null;
        }
        return new ImageId(id);
    }

}
