package com.integralpivots.gera.infrasctrucuture;

import com.integralpivots.gera.domain.User;
import com.integralpivots.gera.domain.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoImpl implements UserRepo {
    // dependency injection
    //private UserDao userDao;
    // UserRepoImpl(UserDao puserDao){
    //      this.userDao = puserDao
    // }

    @Autowired
    UsersDao usersDao;

    @Override
    public User saveUser(User user) {
        return usersDao.save(user);
    }

    @Override
    public User updateAlias(Long id, String alias) {
        User existedUser = usersDao.findById(id).orElse(null);
        if(existedUser != null){
            existedUser.setAlias(alias);
            usersDao.save(existedUser);
            return existedUser;
        }else {
            throw new RuntimeException("User does not exist");
        }
    }

    @Override
    public User findUserByEmail(String email) {
        return usersDao.findByEmail(email);
    }

    @Override
    public User findUserById(Long id) {
        return usersDao.findById(id).orElse(null);
    }

}
