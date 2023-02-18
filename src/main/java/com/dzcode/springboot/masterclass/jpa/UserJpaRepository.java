package com.dzcode.springboot.masterclass.jpa;

import com.dzcode.springboot.masterclass.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    public void deleteById(long id) {
        User user = findById(id);
        entityManager.remove(user);
    }

    public User update(User user) {
        return entityManager.merge(user);
    }

    public User create(User user) {
        return entityManager.merge(user);
    }
}
