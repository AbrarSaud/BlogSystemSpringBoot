package com.example.lab11.Repository;

import com.example.lab11.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    //     Endpoint #1
    User findUserById(Integer userId);

    //     Endpoint #8
    @Query("select u from User u where u.registration_date < ?1")
    List<User> getUsersRegisteredBefore(String date);

}
