package com.clockworkjava.kursspring.domain;


public class Quest {
    private int id;
    private String desription;
    private int reward = 100;
    private int length = 30000;
    private boolean started = false;
    private boolean finished = false;

    public Quest(int id, String desription)
    {
        this.id=id;
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
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
