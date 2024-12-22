package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select u from User u left join fetch u.roles where u.userName = :userName")
    User findByUserName(@Param("userName") String userName);

    @Query("SELECT u FROM User u WHERE u.id = :id")
    User getUserById(@Param("id") Long id);
}