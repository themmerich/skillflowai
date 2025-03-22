package com.primeux.skillflowai.training.infrastructure.persistence.jpa;

import com.primeux.skillflowai.shared.tenant.TenantAwareEntity;
import com.primeux.skillflowai.shared.tenant.TenantAwareEntityListener;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.TenantId;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "enrolled_user")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(TenantAwareEntityListener.class)
public class EnrolledUserEntity implements TenantAwareEntity {
    @Id
    private UUID id;
    private UUID userId;
    private UUID courseId;
    @TenantId
    private String tenantId;
    private LocalDateTime enrolledAt;

}
