package com.integralpivots.gera.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="user_role")
@IdClass(UserRolePK.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    private String description;
    @Id
    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role role;
}
