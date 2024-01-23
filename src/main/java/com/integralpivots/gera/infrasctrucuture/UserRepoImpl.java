package com.integralpivots.gera.infrasctrucuture;

import com.integralpivots.gera.GeraException;
import com.integralpivots.gera.domain.User;
import com.integralpivots.gera.domain.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoImpl implements UserRepo {
    // dependency injection
    //private UserDao userDao;
    // UserRepoImpl(UserDao puserDao){
    //      this.userDao = puserDao
    // }

    @Autowired
    UsersDao userDao;
    @Override
    public User saveUser(User user) {
        try{
            return userDao.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw GeraException.builder().code(GeraException.DATA_ALREADY_EXIST).message("Email already registered").build();
        }
    }

    @Override
    public User updateAlias(Long id, String alias) {
        User existedUser = userDao.findById(id).orElse(null);
        if (existedUser != null) {
            existedUser.setAlias(alias);
            userDao.save(existedUser);
            return existedUser;
        } else {
            throw GeraException.builder().code(GeraException.DATA_NOT_EXIST).message("User not found").build();
        }
    }

    @Override
    public User findUserByEmail(String email) {
        User existedUser = userDao.findByEmail(email);
        if (existedUser != null) {
            return existedUser;
        } else {
            throw GeraException.builder().code(GeraException.DATA_NOT_EXIST).message("This email is not registered").build();
        }
    }

    @Override
    public User findUserById(Long id) {
        User existedUser = userDao.findById(id).orElse(null);
        if (existedUser != null) {
            return existedUser;
        } else {
            throw GeraException.builder().code(GeraException.DATA_NOT_EXIST).message("User not found").build();
        }
    }


}
