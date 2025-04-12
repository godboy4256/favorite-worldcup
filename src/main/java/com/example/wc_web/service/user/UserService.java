package com.example.wc_web.service.user;


import com.example.wc_web.domain.user.User;
import com.example.wc_web.dto.user.CreateUserRequest;
import com.example.wc_web.repository.user.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void createUser(CreateUserRequest request){
        userRepository.save(
                new User(
                        request.getName(),
                        bCryptPasswordEncoder.encode(request.getPassword()),
                        request.getEmail()
                )
        );
    }
}
