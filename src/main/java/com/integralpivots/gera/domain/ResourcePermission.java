package com.integralpivots.gera.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name ="resource_permission")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourcePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resource_id", referencedColumnName = "id")
    private Resource resource;

    private String permission;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
