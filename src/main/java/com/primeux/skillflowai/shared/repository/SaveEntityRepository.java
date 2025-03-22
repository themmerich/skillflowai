package com.primeux.skillflowai.shared.repository;

public interface SaveEntityRepository<T> {
    
    T save(T entity);
}
