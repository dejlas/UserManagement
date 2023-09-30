package com.kahvana.challenge.repository;

import com.kahvana.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
