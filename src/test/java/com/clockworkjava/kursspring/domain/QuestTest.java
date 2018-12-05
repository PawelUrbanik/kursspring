package com.clockworkjava.kursspring.domain;

import org.junit.Assert;
import org.junit.Test;

public class QuestTest {

    @Test
    public void settingStartedFlag()
    {
        Quest quest = new Quest(1, "Przykładowy quest");
        quest.setStarted(true);

        Assert.assertNotNull(quest.startDate);
    }

    @Test
    public void questShouldBeCompletedAfter()
    {
        Quest quest = new Quest(1, "Zadanie testowe");
        quest.setStarted(true);
        quest.lengthSeconds = -60;
        Assert.assertTrue(quest.isCompleted());
        Assert.assertTrue(quest.isCompleted());
    }

    @Test
    public void questShouldBeNotCompletedAfter()
    {
        Quest  quest = new Quest(1 , "Zadanie testowe");
        quest.setStarted(true);
        quest.lengthSeconds=20000;
        Assert.assertFalse(quest.isCompleted());
        Assert.assertFalse(quest.isCompleted());

    }
}
