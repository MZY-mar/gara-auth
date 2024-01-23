package com.integralpivots.gera.domain;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Lob
    private String Description;


    /*It is used in Java code to specify that a field in an entity class (like
     your Organization class) is part of a many-to-one relationship with another
      entity class (like User). */

    //Organization has one owner (a User), but a single User can own multiple
    // Organization instances.
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User user;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
