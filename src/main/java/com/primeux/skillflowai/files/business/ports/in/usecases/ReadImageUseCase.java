package com.primeux.skillflowai.files.business.ports.in.usecases;

import com.primeux.skillflowai.files.business.domain.model.Image;
import com.primeux.skillflowai.files.business.domain.model.ImageId;
import com.primeux.skillflowai.shared.usecase.ReadEntityUseCase;

public interface ReadImageUseCase extends ReadEntityUseCase<Image, ImageId> {
}
