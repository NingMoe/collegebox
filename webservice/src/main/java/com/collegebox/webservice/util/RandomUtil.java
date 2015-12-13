package com.collegebox.webservice.util;

import java.util.Date;
import java.util.Random;

public class RandomUtil {
	
	public static final String getRandom(int num) {
		Random rand = new Random(new Date().getTime());
		int cnt = 26 * 2 + 10;
		char[] s = new char[num];
		for (int i = 0; i < num; i++) {
			int v = rand.nextInt(cnt);
			if (v < 10)
				s[i] = (char) ('0' + v);
			else if (v < 36)
				s[i] = (char) (v - 10 + 'A');
			else
				s[i] = (char) (v - 36 + 'a');
		}
		return new String(s);
	}

}
