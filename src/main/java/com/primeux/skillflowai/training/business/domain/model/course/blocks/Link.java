package com.primeux.skillflowai.training.business.domain.model.course.blocks;

import lombok.Getter;

@Getter
public class Link extends Block {

    private final String url;

    public Link(String url) {
        super(BlockType.LINK);
        this.url = url;
    }
}
