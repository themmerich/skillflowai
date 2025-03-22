package com.primeux.skillflowai.training.business.domain.model.course;

import com.primeux.skillflowai.training.business.domain.model.course.blocks.Block;
import lombok.Data;

@Data
public class Section {
    private int order;
    private String title;
    private String description;
    private Block content;
}
