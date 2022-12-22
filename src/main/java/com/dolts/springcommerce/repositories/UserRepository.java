package com.dolts.springcommerce.repositories;

import com.dolts.springcommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
