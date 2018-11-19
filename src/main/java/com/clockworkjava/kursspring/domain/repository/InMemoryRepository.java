package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@Profile("dev")
public class InMemoryRepository implements KnightRepository {

    private Map<Integer, Knight> knights = new HashMap<>();

    public InMemoryRepository() {}

    @Override
    @PostConstruct
    public void build()
    {
        createKnight("Lancelot", 29);
        createKnight("Percival", 25);
    }

    @Override
    public void createKnight(String name, int age)
    {
        Knight newKnight = new Knight(name, age);
        newKnight.setId(getNewId());
        knights.put(newKnight.getId(), newKnight);
    }

    @Override
    public Collection<Knight> getAllKnights()
    {
        return knights.values();
    }

    @Override
    public Optional<Knight> getKnight(String name)
    {
        Optional<Knight> knightByName = knights.values().stream().filter(knight -> knight.getName().equals(name)).findAny();
        return knightByName;
    }

    @Override
    public void deleteKnight(Integer id)
    {
        knights.remove(id);
    }

    @Override
    public void createKnight(Knight knight) {
        knights.put(knight.getId(), knight);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return knights.get(id);
    }


    @Override
    public String toString() {
        return "KnightRepository{" +
                "knights=" + knights +
                '}';
    }

    private int getNewId() {
        if (knights.isEmpty())
        {
            return 0;
        }
        else
        {
            Integer integer = knights.keySet().stream().max(Integer::max).get();
            return integer+1;
        }
    }
}
