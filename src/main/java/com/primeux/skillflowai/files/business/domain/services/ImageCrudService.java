package com.primeux.skillflowai.files.business.domain.services;

import com.primeux.skillflowai.files.business.domain.model.Image;
import com.primeux.skillflowai.files.business.domain.model.ImageId;
import com.primeux.skillflowai.files.business.ports.in.usecases.CreateImageUseCase;
import com.primeux.skillflowai.files.business.ports.in.usecases.ReadImageUseCase;
import com.primeux.skillflowai.files.business.ports.out.repositories.ImageRepository;
import com.primeux.skillflowai.shared.annotation.UseCase;
import lombok.RequiredArgsConstructor;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.List;
import java.util.Optional;

@UseCase
@RequiredArgsConstructor
class ImageCrudService implements CreateImageUseCase, ReadImageUseCase {

    private final ImageRepository imageRepository;

    @Override
    public ImageId create(CreateImageCommand command) {
        Image image = new Image();
        image.setId(new ImageId());
        image.setFilename(command.filename());
        image.setImageBytes(command.imageBytes());
        String mimeType = guessMimeType(command.imageBytes());
        if (mimeType == null || !mimeType.startsWith("image")) {
            throw new RuntimeException("The provided file seems not to be an image");
        }
        image.setMimeType(mimeType);
        Image savedImage = imageRepository.save(image);
        return savedImage.getId();
    }

    private String guessMimeType(byte[] imageBytes) {
        try {
            InputStream is = new BufferedInputStream(new ByteArrayInputStream(imageBytes));
            return URLConnection.guessContentTypeFromStream(is);
        } catch (IOException e) {
            throw new RuntimeException("Could not guess mime type", e);
        }
    }

    @Override
    public Optional<Image> read(ImageId imageId) {
        return imageRepository.findById(imageId);
    }

    @Override
    public List<Image> readAll() {
        return imageRepository.findAll();
    }
}
