package com.clockworkjava.kursspring.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Entity
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String desription;
    private int reward = 100;
    protected int lengthSeconds = 10;
    protected LocalDateTime startDate;
    private boolean started = false;
    private boolean completed = false;

    public Quest() {
    }

    public Quest(int id, String desription)
    {
        this.id=id;
        this.desription = desription;
    }

    public Quest(String desription) {
        this.desription = desription;
    }

    @Override
    public String toString() {
        return desription;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getLength() {
        return lengthSeconds;
    }

    public void setLength(int length) {
        this.lengthSeconds = length;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        if (started)
        {
            this.startDate = LocalDateTime.now();
        }
        this.started = started;
    }

    public boolean isCompleted() {
        if (this.completed)
        {
            return this.completed;
        }else
        {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime questEndDate = this.startDate.plusSeconds(this.lengthSeconds);

            boolean isAfter = now.isAfter(questEndDate);

            if(isAfter)
            {
                this.completed = true;
            }
            return isAfter;
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
