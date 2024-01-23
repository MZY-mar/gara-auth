package com.integralpivots.gera.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name ="role")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

//@Data annotation is a convenient shortcut that bundles the features of
// @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String organizationId;
    private  String name;
    @Lob
    //A LOB is a large field
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
