package com.clockworkjava.kursspring.utils;


import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class IdsTest {

    @Test
    public void testEmptySet()
    {
        int result = Ids.getNewId(Collections.emptySet());
        Assert.assertEquals(0, result);
    }

    @Test
    public void testGenerateNewId()
    {
        Set<Integer> sample = new HashSet<>();
        sample.add(1);
        sample.add(2);
        sample.add(3);
        int result = Ids.getNewId(sample);
        Assert.assertEquals(4, result);
    }
}
