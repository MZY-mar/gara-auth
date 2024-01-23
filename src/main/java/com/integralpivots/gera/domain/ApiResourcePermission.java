package com.integralpivots.gera.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "api_resource_permission")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResourcePermission {
    @Id
    @Column(columnDefinition = "VARCHAR(255)")
    private String url;

    @ManyToOne
    @JoinColumn(name = "reource_permission_id", referencedColumnName = "id")
    private  ResourcePermission resourcePermission;
}
