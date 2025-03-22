package com.primeux.skillflowai.shared.repository;

import java.util.List;
import java.util.Optional;

public interface ReadEntityRepository<T, ID> {

    Optional<T> findById(ID id);

    List<T> findAll();
}
