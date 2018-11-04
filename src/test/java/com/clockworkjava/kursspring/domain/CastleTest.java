package com.clockworkjava.kursspring.domain;

import com.clockworkjava.kursspring.domain.Castle;
import com.clockworkjava.kursspring.domain.Knight;
import org.junit.Assert;
import org.junit.Test;

public class CastleTest {

    @Test
    public void castleToStringMessage()
    {
        Quest quest = new Quest();
        Knight knight = new Knight();
        knight.setQuest(quest);
        Castle castle = new Castle(knight, "Castle black");
        String except= "Znaleziono zamek: Castle black Zamieszkały przez rycerza: Rycerz o imieniu Lancelot(29) Zadanie: Zadanie: Uratuj księżniczke ";
        Assert.assertEquals(except, castle.toString());
    }
}
