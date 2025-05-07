package com.thabng.trading.Service;

import com.thabng.trading.Repository.UserRepository;
import com.thabng.trading.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //Injecting the repository into our Service
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
}
