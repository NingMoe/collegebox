package com.collegebox.webservice;

import org.junit.Test;

import com.collegebox.webservice.util.RandomUtil;

public class RandomTest {
	
	@Test
	public void test() {
		System.out.println("RANDOM 4 : " + RandomUtil.getRandom(4));
	}

}
