package com.clockworkjava.kursspring;

public class PersonUtils {

    private static PersonUtils instance= null;

    private PersonUtils(){};

    private PersonUtils getInstance()
    {
        if (instance==null)
        {
            instance=new PersonUtils();
        }

        return instance;
    }

    public final String operacja(Person person)
    {
        return person.toString();
    }
}
