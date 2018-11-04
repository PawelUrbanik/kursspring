package com.clockworkjava.kursspring;

import com.clockworkjava.kursspring.domain.Castle;
import com.clockworkjava.kursspring.domain.Knight;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KursspringApplicationTests {

	@Autowired
	Knight knight;

	@Autowired
	Castle castle;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCastle()
	{
		String except= "Znaleziono zamek: Castle black Zamieszkały przez rycerza: Rycerz o imieniu Lancelot(29) Zadanie: Zadanie: Uratuj księżniczke ";
		Assert.assertEquals(except, castle.toString());
	}

}
