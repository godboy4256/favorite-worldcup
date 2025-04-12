package com.example.wc_web.repository.user;

import com.example.wc_web.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
