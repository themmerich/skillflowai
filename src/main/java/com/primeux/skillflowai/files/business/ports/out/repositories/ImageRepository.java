package com.primeux.skillflowai.files.business.ports.out.repositories;

import com.primeux.skillflowai.files.business.domain.model.Image;
import com.primeux.skillflowai.files.business.domain.model.ImageId;
import com.primeux.skillflowai.shared.repository.ReadEntityRepository;
import com.primeux.skillflowai.shared.repository.SaveEntityRepository;

public interface ImageRepository extends ReadEntityRepository<Image, ImageId>, SaveEntityRepository<Image> {

}
