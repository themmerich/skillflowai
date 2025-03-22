package com.primeux.skillflowai.training.business.domain.model.course.blocks;

import com.primeux.skillflowai.files.business.domain.model.ImageId;
import lombok.Getter;

@Getter
public class ImageBlock extends Block {

    private final ImageId id;

    public ImageBlock(ImageId id) {
        super(BlockType.IMAGE);
        this.id = id;
    }
}
