package com.primeux.skillflowai.shared.usecase;

import java.util.List;
import java.util.Optional;

public interface ReadEntityUseCase<T, ID> {

    Optional<T> read(ID id);

    List<T> readAll();
}
