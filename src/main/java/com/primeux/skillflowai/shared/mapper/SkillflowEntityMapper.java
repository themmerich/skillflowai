package com.primeux.skillflowai.shared.mapper;

import org.mapstruct.Named;

import java.time.Period;
import java.util.UUID;

public interface SkillflowEntityMapper {

    @Named("uuidAsString")
    default String uuidAsString(UUID id) {
        return id.toString();
    }

    @Named("period")
    default Period toPeriod(String period) {
        if (period == null) {
            return null;
        }
        return Period.parse(period);
    }
}
