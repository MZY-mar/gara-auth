package com.integralpivots.gera.domain;

public interface UserRepo {
    User saveUser(User user);
    User updateAlias(Long id, String alias);
    User findUserByEmail(String email);
    User findUserById(Long id);

}
