package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.utils.Ids;
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

    private Map<Integer, Knight> knights;

    public InMemoryRepository() {}

    @Override
    @PostConstruct
    public void build()
    {
        knights = new HashMap<>();
        createKnight("Lancelot", 29);
        createKnight("Percival", 25);
    }

    @Override
    public void createKnight(String name, int age)
    {
        Knight newKnight = new Knight(name, age);
        newKnight.setId(Ids.getNewId(knights.keySet()));
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
        knight.setId(Ids.getNewId(knights.keySet()));
        System.out.println(knight.getId());
        knights.put(knight.getId(), knight);
    }

    @Override
    public void updateKnight(int id, Knight knight) {
        knights.put(id, knight);
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

}
