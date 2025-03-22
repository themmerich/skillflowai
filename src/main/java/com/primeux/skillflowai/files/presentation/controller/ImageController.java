package com.primeux.skillflowai.files.presentation.controller;

import com.primeux.skillflowai.files.business.domain.model.Image;
import com.primeux.skillflowai.files.business.domain.model.ImageId;
import com.primeux.skillflowai.files.business.ports.in.usecases.ReadImageUseCase;
import com.primeux.skillflowai.shared.annotation.SkillflowRestController;
import com.primeux.skillflowai.shared.security.CommonAuthorities;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@SkillflowRestController("/api/file/image")
@RequiredArgsConstructor
public class ImageController {

    private final ReadImageUseCase readImageUseCase;
    
    @GetMapping("/{id}")
    @ResponseBody
    @PreAuthorize(CommonAuthorities.PERMIT_ALL)
    public byte[] read(@PathVariable String id) {
        return readImageUseCase.read(ImageId.fromString(id)).map(Image::getImageBytes).orElseThrow(() -> new RuntimeException("Image not found for id " + id));
    }
}
