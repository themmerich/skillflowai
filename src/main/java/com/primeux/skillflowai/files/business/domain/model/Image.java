package com.primeux.skillflowai.files.business.domain.model;

import lombok.Data;

@Data
public class Image {
    private ImageId id;
    private String filename;
    private String mimeType;
    private byte[] imageBytes;
}
