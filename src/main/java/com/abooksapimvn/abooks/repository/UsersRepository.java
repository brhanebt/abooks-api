package com.abooksapimvn.abooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abooksapimvn.abooks.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long>{
    
    @Query(name = "findAllByLocation")
    List<User> findAllByLocation(@Param("locations") List<String> locations);
}
