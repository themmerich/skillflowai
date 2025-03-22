package com.primeux.skillflowai.training.business.domain.model.quiz;

public record TimeLimit(int durationInSeconds) {

    public TimeLimit {
        if (durationInSeconds < 0) {
            throw new IllegalArgumentException("Only positive integers allowed");
        }
    }

    public static TimeLimit inSeconds(int seconds) {
        return new TimeLimit(seconds);
    }

    public static TimeLimit inMinutes(int minutes) {
        return new TimeLimit(minutes * 60);
    }
}
