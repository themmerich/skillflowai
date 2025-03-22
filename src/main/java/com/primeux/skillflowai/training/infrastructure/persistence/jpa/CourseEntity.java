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

import java.util.UUID;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(TenantAwareEntityListener.class)
public class CourseEntity implements TenantAwareEntity {

    @Id
    private UUID id;
    @TenantId
    private String tenantId;
    private String title;
    private String description;
    private String status;
    private String repeatInterval;  // a time-period containing years, month and days in ISO-8601 period format, e.g. P1Y3M15D for 1year, 3month, 15days
    private UUID courseImage;
}
