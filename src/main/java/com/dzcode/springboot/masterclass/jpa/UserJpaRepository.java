package com.dzcode.springboot.masterclass.jpa;

import com.dzcode.springboot.masterclass.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public User findById(long id) {
        return entityManager.find(User.class, id);
    }
}
