package com.primeux.skillflowai.training.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface SpringDataCourseJpaRepository extends JpaRepository<CourseEntity, UUID> {
}
