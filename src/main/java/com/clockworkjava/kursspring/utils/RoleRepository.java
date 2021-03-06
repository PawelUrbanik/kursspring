package com.clockworkjava.kursspring.utils;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class RoleRepository {
    @PersistenceContext
    EntityManager manager;

    @Transactional
    public void persistRole(Role role)
    {
        manager.persist(role);
    }
}
