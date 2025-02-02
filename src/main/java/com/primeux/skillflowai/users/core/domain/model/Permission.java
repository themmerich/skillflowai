package com.primeux.skillflowai.users.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Permission {

    private final String code;
    private String description;
}
