package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;
@Service
public class QuestFormatter implements Formatter<Quest> {

    @Autowired
    QuestRepository questRepository;

    @Override
    public Quest parse(String idString, Locale locale) throws ParseException {
        Integer id = Integer.parseInt(idString);
        Quest quest = questRepository.getQuest(id);
        return quest;
    }

    @Override
    public String print(Quest quest, Locale locale) {
        return quest.toString();
    }
}
