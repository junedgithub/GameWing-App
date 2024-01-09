package com.ty.gamewingmanagementapp.dao;

import com.ty.gamewingmanagementapp.dto.Role;
import com.ty.gamewingmanagementapp.dto.User;
import com.ty.gamewingmanagementapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDao {
    @Autowired
    private UserRepository userRepository;
    public User register(User user) {
        if(user.getRole().equals(Role.Admin)){
            userRepository.save(user);
            return user;
        }else {
            return null;
        }
    }

    public User addOwner(User owner) {
        User admin = userRepository.findByRole(Role.Admin);
        if (admin!=null){
            User user = userRepository.save(owner);
            return user;
        }else{
            return null;
        }
    }


    public User login(User user) {
        User user1 = userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
        if (user1!=null){
            return user1;
        }else
            return null;
    }

    public User deleteOwner(int id) {
        User admin = userRepository.findByRole(Role.Admin);
        if (admin!=null){
            Optional<User> optOwner = userRepository.findById(id);
            if (optOwner.isPresent()){
                User recOwner = optOwner.get();
                userRepository.delete(recOwner);
                return recOwner;
            }else
                return null;
        }else {
            return null;
        }
    }

    public User addManager(User manager) {
        User admin = userRepository.findByRole(Role.Admin);
        if (admin!=null){
            User user = userRepository.save(manager);
            return user;
        }else{
            return null;
        }
    }

    public User deleteManager(int id) {
        User admin = userRepository.findByRole(Role.Admin);
        if (admin!=null){
            Optional<User> optManager = userRepository.findById(id);
            if (optManager.isPresent()){
                User recManager = optManager.get();
                userRepository.delete(recManager);
                return recManager;
            }else
                return null;
        }else {
            return null;
        }
    }

    public User updateManager(int id, User updateManager) {
        User admin = userRepository.findByRole(Role.Admin);
        if (admin!=null){
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()){
                User manager = optionalUser.get();
                if (manager!=null){
                    manager.setName(updateManager.getName());
                    manager.setEmail(updateManager.getEmail());
                    manager.setPassword(updateManager.getPassword());
                    manager.setRole(updateManager.getRole());
                    userRepository.save(manager);
                    return manager;
                }else{
                    return null;
                }
            }else {
                return null;
            }
        }else 
            return null;
    }

    public User updateOwner(int id, User updateOwner) {
        User admin = userRepository.findByRole(Role.Admin);
        if (admin!=null){
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()){
                User owner = optionalUser.get();
                if (owner!=null){
                    owner.setName(updateOwner.getName());
                    owner.setEmail(updateOwner.getEmail());
                    owner.setPassword(updateOwner.getPassword());
                    owner.setRole(updateOwner.getRole());
                    userRepository.save(owner);
                    return owner;
                }else{
                    return null;
                }
            }else {
                return null;
            }
        }else
            return null;
    }

    public User addCustomer(User customer) {
        User manager = userRepository.findByRole(Role.Manager);
        if (manager!=null){
            User user = userRepository.save(customer);
            return user;
        }else{
            return null;
        }
    }

    public User deleteCustomer(int id) {
        User manager = userRepository.findByRole(Role.Manager);
        if (manager!=null){
            Optional<User> optCustomer = userRepository.findById(id);
            if (optCustomer.isPresent()){
                User recCustomer = optCustomer.get();
                userRepository.delete(recCustomer);
                return recCustomer;
            }else
                return null;
        }else {
            return null;
        }
    }
}
