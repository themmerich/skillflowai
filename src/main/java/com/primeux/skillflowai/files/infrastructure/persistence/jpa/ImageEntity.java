package com.primeux.skillflowai.files.infrastructure.persistence.jpa;

import com.primeux.skillflowai.shared.tenant.TenantAwareEntity;
import com.primeux.skillflowai.shared.tenant.TenantAwareEntityListener;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.TenantId;

import java.util.UUID;

@Entity
@Table(name = "image")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(TenantAwareEntityListener.class)
public class ImageEntity implements TenantAwareEntity {
    @Id
    private UUID id;
    @TenantId
    private String tenantId;

    private String filename;

    @ToString.Exclude
    private byte[] data;

    private String mimeType;
}
