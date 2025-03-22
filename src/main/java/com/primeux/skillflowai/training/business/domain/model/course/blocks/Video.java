package com.primeux.skillflowai.training.business.domain.model.course.blocks;

import lombok.Getter;

@Getter
public class Video extends Block {

    private final String url;

    public Video(String url) {
        super(BlockType.VIDEO);
        this.url = url;
    }
}
