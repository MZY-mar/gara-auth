package com.integralpivots.gera.infrasctrucuture;

import com.integralpivots.gera.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDao extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
