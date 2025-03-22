package com.primeux.skillflowai.files.infrastructure.persistence.jpa;

import com.primeux.skillflowai.files.business.domain.model.Image;
import com.primeux.skillflowai.files.business.domain.model.ImageId;
import com.primeux.skillflowai.files.business.ports.out.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
class ImageJpaRepository implements ImageRepository {
    private final SpringDataImageJpaRepository springDataImageJpaRepository;
    private final FileMapper mapper;

    @Override
    public Optional<Image> findById(ImageId imageId) {
        return springDataImageJpaRepository.findById(imageId.id()).map(mapper::toImage);
    }

    @Override
    public List<Image> findAll() {
        return springDataImageJpaRepository.findAll().stream().map(mapper::toImage).toList();
    }

    @Override
    public Image save(Image image) {
        ImageEntity saved = springDataImageJpaRepository.save(mapper.toImageEntity(image));
        return mapper.toImage(saved);
    }
}
