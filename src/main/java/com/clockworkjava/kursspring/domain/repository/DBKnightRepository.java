package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Repository
@Profile("prod")
public class DBKnightRepository implements KnightRepository {

    @PersistenceContext
    EntityManager manager;

    @Override
    public void createKnight(String name, int age) {
        Knight knight = new Knight(name, age);
        manager.persist(knight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return manager.createQuery("from Knight").getResultList();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        Knight knight = manager.createQuery("from Knight k where k.name=:name", Knight.class).setParameter("name", name).getSingleResult();
        return Optional.ofNullable(knight);
    }

    @Override
    @Transactional
    public void deleteKnight(Integer id) {
        manager.remove(getKnightById(id));
    }

    @Override
    @PostConstruct
    public void build() {

    }

    @Override
    @Transactional
    public void createKnight(Knight knight) {
        manager.persist(knight);
    }

    @Override
    public Knight getKnightById(Integer id) {
        Knight knight = manager.find(Knight.class, id);
        return knight;
    }

    @Override
    @Transactional
    public void updateKnight(int id, Knight knight) {
        manager.merge(knight);
    }
}
