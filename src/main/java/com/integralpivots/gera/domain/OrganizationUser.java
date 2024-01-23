package com.integralpivots.gera.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "organization_user")
@IdClass(OrganizationUserPK.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrganizationUser {
    @Id
    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private  Organization organization;
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private  User user;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

}
