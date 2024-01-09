package com.ty.gamewingmanagementapp.repository;

import com.ty.gamewingmanagementapp.dto.Role;
import com.ty.gamewingmanagementapp.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByRole(Role role);

    User findByEmailAndPassword(String email,String passowrd);
}
