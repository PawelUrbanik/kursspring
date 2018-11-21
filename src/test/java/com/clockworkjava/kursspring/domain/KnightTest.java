package com.clockworkjava.kursspring.domain;

import org.junit.Assert;
import org.junit.Test;

public class KnightTest {

    @Test
    public void questIsMarkedAsStarted()
    {
        Knight knight = new Knight("Przykładowy",32);
        Quest quest = new Quest(1,"Przykładowy test");
        knight.setQuest(quest);

        Assert.assertTrue(knight.getQuest().isStarted());
    }
}
