package com.abooksapimvn.abooks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abooksapimvn.abooks.model.User;
import com.abooksapimvn.abooks.repository.UsersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UsersService {

    private final UsersRepository usersRepository;

    @Transactional(readOnly=true)
    public Optional<User> getUserById(Long userId){
        return usersRepository.findById(userId);
    }

    @Transactional(readOnly=true)
    public List<User> getAllUsers(){
        return usersRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<User> getAllUsersByIdList(List<Long> userIds){
        return usersRepository.findAllById(userIds);
    }

    @Transactional(readOnly=true)
    public List<User> getAllUsersByLocations(List<String> locations) {
        return usersRepository.findAllByLocation(locations);
    }

    @Transactional
    public User saveUser(User user) {
        return usersRepository.save(user);
    }
}
