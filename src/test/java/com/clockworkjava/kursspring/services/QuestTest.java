package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestTest {

    @Mock
    QuestRepository repositoryMock;

    @Test
    public void returnsNotStartedQuests()
    {
        List<Quest> quests = new ArrayList<>();
        Quest q1 = new Quest(1,"Test1");
        Quest q2 = new Quest(2,"Test2");
        Quest q3 = new Quest(3,"Test3");

        quests.add(q1);
        quests.add(q2);
        quests.add(q3);

        q2.setStarted(true);

        when(repositoryMock.getAll()).thenReturn(quests);

        QuestService service = new QuestService();

        service.setQuestRepository(repositoryMock);

        List<Quest> allNotStartedQuests = service.getAllNotStartedQuests();
        Assert.assertEquals(2, allNotStartedQuests.size());
        Assert.assertThat(allNotStartedQuests, containsInAnyOrder(q1,q3));
    }
}
