package com.primeux.skillflowai.training.business.domain.model.course.blocks;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Block {

    private final BlockType type;
}
