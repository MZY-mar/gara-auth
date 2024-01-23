package com.integralpivots.gera.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String alias;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    private String fullname;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private LocalDateTime loginAt;
}
