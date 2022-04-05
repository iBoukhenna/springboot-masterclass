package com.dzcode.springboot.masterclass.repository;

import com.dzcode.springboot.masterclass.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
