package com.primeux.skillflowai.training.business.domain.model.course.blocks;

import lombok.Getter;

@Getter
public class Text extends Block {

    private final String value;

    public Text(String value) {
        super(BlockType.TEXT);
        this.value = value;
    }
}
