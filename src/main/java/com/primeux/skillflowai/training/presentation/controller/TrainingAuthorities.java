package com.primeux.skillflowai.training.presentation.controller;

import com.primeux.skillflowai.shared.security.CommonAuthorities;

class TrainingAuthorities extends CommonAuthorities {
    static final String READ_COURSE = "hasAuthority('COURSE_READ')";
    static final String CREATE_COURSE = "hasAuthority('COURSE_CREATE')";
    static final String UPDATE_COURSE = "hasAuthority('COURSE_UPDATE')";
    static final String DELETE_COURSE = "hasAuthority('COURSE_DELETE')";

    static final String READ_QUIZ = "hasAuthority('QUIZ_READ')";
    static final String CREATE_QUIZ = "hasAuthority('QUIZ_CREATE')";
    static final String UPDATE_QUIZ = "hasAuthority('QUIZ_UPDATE')";
    static final String DELETE_QUIZ = "hasAuthority('QUIZ_DELETE')";
}
