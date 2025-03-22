package com.primeux.skillflowai.training.business.domain.model.course.blocks;

import lombok.Getter;

@Getter
public class Document extends Block {

    private final String url;

    public Document(String url) {
        super(BlockType.DOCUMENT);
        this.url = url;
    }
}
